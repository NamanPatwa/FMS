package com.cg.dao;

import java.util.List;

import com.cg.bean.CourseMaster;
import com.cg.exception.CourseNotFoundException;
import com.cg.exception.InvalidCourseException;
/**
 * FMS - Course Master Dao
 * @version 1.0
 * This is DAO class for Course Master
 */
public interface CourseMasterDao {
	
	String saveCourseQuery = "INSERT INTO COURSE_MASTER VALUES(courseid_seq.nextval,?,?)";
	String getCourseQuery = "SELECT * FROM COURSE_MASTER WHERE COURSE_ID=?";
	String getAllCoursesQuery = "SELECT * FROM COURSE_MASTER";
	String removeCourseQuery = "DELETE FROM COURSE_MASTER WHERE COURSE_ID=?";
	String getCourseIdQuery = "SELECT courseid_seq.currval FROM dual";
	String fetchCourseIdQuery = "SELECT * FROM COURSE_MASTER WHERE COURSE_ID=?";
	String updateCourseByIdQuery = "UPDATE COURSE_MASTER SET COURSE_NAME=?, NO_OF_DAYS=? WHERE COURSE_ID=?";
	/**
	 * 
	 * @param course
	 * @return
	 * @throws InvalidCourseException
	 */
	int addCourse(CourseMaster course) throws InvalidCourseException;
	/**
	 * 
	 * @return
	 * @throws CourseNotFoundException
	 */
	List<CourseMaster> fetchAllCourses() throws CourseNotFoundException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws InvalidCourseException
	 */
	CourseMaster fetchCourseByCourseId(int id) throws InvalidCourseException;
	/**
	 * 
	 * @param course
	 * @return
	 * @throws InvalidCourseException
	 */
	CourseMaster updateCourse(CourseMaster course) throws InvalidCourseException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws InvalidCourseException
	 */
	boolean removeCourse(int id) throws InvalidCourseException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws InvalidCourseException
	 */
	boolean courseExist(int id) throws InvalidCourseException;
}
