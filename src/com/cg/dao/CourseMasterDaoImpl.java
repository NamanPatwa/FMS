package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.CourseMaster;
import com.cg.exception.CourseNotFoundException;
import com.cg.exception.InvalidCourseException;

public class CourseMasterDaoImpl implements CourseMasterDao {

	@Override
	public int addCourse(CourseMaster course) throws InvalidCourseException {
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(saveCourseQuery);
			//stmt.setInt(1, course.getCourseId());
			stmt.setString(1, course.getCourseName());
			stmt.setInt(2, course.getDays());
			
			stmt.executeUpdate();
			ResultSet result = conn.createStatement().executeQuery(getCourseIdQuery);
			if(result.next())
				return result.getInt(1);
			else 
				return 0;
		} catch (SQLException e) {
			throw new InvalidCourseException(e.getMessage());
		} finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public List<CourseMaster> fetchAllCourses() throws CourseNotFoundException {
		List<CourseMaster> courses = new ArrayList<CourseMaster>();
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(getAllCoursesQuery);
			
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				CourseMaster course = new CourseMaster();
				course.setCourseId(result.getInt(1));
				course.setCourseName(result.getString(2));
				course.setDays(result.getInt(3));
				courses.add(course);
			}
			if(courses.size() == 0)
				throw new CourseNotFoundException();
			return courses;
		} catch (SQLException e) {
			throw new CourseNotFoundException(e.getMessage());
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public CourseMaster fetchCourseByCourseId(int id) throws InvalidCourseException {
		Connection conn = null;
		CourseMaster course = null;

		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(getCourseQuery);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			if(!result.next()) {
				throw new InvalidCourseException("Course does not exist..");
			}
			else {
				course = new CourseMaster();
				course.setCourseId(result.getInt(1));
				course.setCourseName(result.getString(2));
				course.setDays(result.getInt(3));
			}
				
			return course;
		} catch (SQLException e) {
			throw new InvalidCourseException(e.getMessage());
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public CourseMaster updateCourse(CourseMaster course) throws InvalidCourseException {
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt1 = conn.prepareStatement(fetchCourseIdQuery);
			stmt1.setInt(1, course.getCourseId());
			ResultSet result = stmt1.executeQuery();
			if(!result.next())
				throw new InvalidCourseException("Course details can not be updated.. course id not found.");
			else {
				PreparedStatement stmt2 = conn.prepareStatement(updateCourseByIdQuery);
				stmt2.setString(1, course.getCourseName());
				stmt2.setInt(2, course.getDays());
				stmt2.setInt(3, course.getCourseId());
				stmt2.executeUpdate();
				stmt2.execute();
			}
			return course;
		} catch (SQLException e) {
			throw new InvalidCourseException(e.getMessage());
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean removeCourse(int id) throws InvalidCourseException {
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt1 = conn.prepareStatement(fetchCourseIdQuery);
			stmt1.setInt(1, id);
			ResultSet result = stmt1.executeQuery();
			if(!result.next())
				throw new InvalidCourseException("Course details can not be deleted.. course id not found.");
			else {
				PreparedStatement stmt = conn.prepareStatement(removeCourseQuery);
				stmt.setInt(1, id);
				stmt.executeUpdate();
				return true;
			}
			
		} catch (SQLException e) {
			throw new InvalidCourseException(e.getMessage());
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean courseExist(int id) throws InvalidCourseException {
		Connection conn = null;
		CourseMaster course = null;
		System.out.println("pehle");

		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(getCourseQuery);
			stmt.setInt(1, id);
			System.out.println("before get course");
			ResultSet result = stmt.executeQuery();
			System.out.println("after");
			if(result.next()) {
				return true;
			} else
				return false;
		} catch (SQLException e) {
			throw new InvalidCourseException(e.getMessage());
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
