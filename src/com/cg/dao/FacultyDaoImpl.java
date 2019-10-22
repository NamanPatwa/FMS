package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.bean.Faculty;
import com.cg.exception.FacultyDoesNotExist;

public class FacultyDaoImpl implements FacultyDao {

	@Override
	public int addFacultySkill(Faculty faculty) throws FacultyDoesNotExist {
		
		Connection conn = null;
		
//		try {
//			conn = JdbcUtil.getConnection();
//			PreparedStatement stmt = conn.prepareStatement(saveFacultySkillsetQuery);
//			stmt.setInt(1, faculty.getFacultyId());
//			stmt.setString(2, faculty.getSkillSet());
//			System.out.println("before saved query");
//			stmt.executeUpdate();		
//			System.out.println("saved query");
//			ResultSet result = stmt.executeQuery(fetchFacultyIdQuery);
//			if(result.next()) {
//				System.out.println("fetch query");
//				return result.getInt(1);
//			}
//			else
//			{
//				System.out.println("no fetch query result");
//				return 0;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new FacultyDoesNotExist(e.getMessage());
//		} finally {
//			if(conn != null)
//			try {
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		
		
		
		
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(fetchFacultyIdQuery);
			stmt.setInt(1, faculty.getFacultyId());
			ResultSet result = stmt.executeQuery();
			if(!result.next()) {
				System.out.println("no fetch query result");
				throw new FacultyDoesNotExist("Faculty id does not exist..");
			} else {
				PreparedStatement stmt1 = conn.prepareStatement(saveFacultySkillsetQuery);
				stmt1.setInt(1, faculty.getFacultyId());
				stmt1.setString(2, faculty.getSkillSet());
				System.out.println("before saved query");
				stmt1.executeUpdate();
				System.out.println("saved query");
			}
				return result.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyDoesNotExist(e.getMessage());
		} finally {
			if(conn != null)
			try {
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
