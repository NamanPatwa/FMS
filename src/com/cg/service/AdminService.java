package com.cg.service;

import java.util.List;

import com.cg.bean.CourseMaster;
import com.cg.bean.Faculty;
import com.cg.exception.CourseNotFoundException;
import com.cg.exception.FacultyDoesNotExist;
import com.cg.exception.InvalidCourseException;
/**
 *@version 1
 *Date Oct 6 2019
 *This is admin sevice interface having regex validation and CRUD Operation related to admin
 */
public interface AdminService {

	String courseIdRule = "[0-9]{1,}";
	String nameRule = "[A-Z][a-z]{1,}";
	String daysRule = "[0-9]{1,}";
	String facultyIdRule = "[0-9]{1,}";
	String skillsetRule = "[A-Za-z]{1,}";
	
	//Method to validate course id
	default boolean validateCourseId(String courseId) {
		return courseId.matches(courseIdRule);
	}
	//Method to validate Course name
	default boolean validateName(String courseName) {
		return courseName.matches(nameRule);
	}
	//Method to validate CourseDays
	default boolean validateDays(String courseDays) {
		return courseDays.matches(daysRule);
	}
	//Method to validate faculty id
	default boolean validateFacultyId(String facultyId) {
		return facultyId.matches(facultyIdRule);
	}
	//Method to validate Skillset
	default boolean validateFacultySkillset(String skillset) {
		return skillset.matches(skillsetRule);
	}
	
	
	//BL methods
	/**
	 * Service method to save course
	 * @param course
	 * @return Integer
	 * @throws InvalidCourseException
	 */
	int saveCourse(CourseMaster course) throws InvalidCourseException;
	/**
	 * Service method to get list of courses
	 * @return
	 * @throws CourseNotFoundException
	 */
	List<CourseMaster> getAllCourses() throws CourseNotFoundException;
	/**
	 * Service method to get course by id
	 * @param id
	 * @return
	 * @throws InvalidCourseException
	 */
	CourseMaster getCourseByCourseId(int id) throws InvalidCourseException;
	/**
	 * service method to update course
	 * @param course
	 * @return
	 * @throws InvalidCourseException
	 */
	CourseMaster updateCourse(CourseMaster course) throws InvalidCourseException;
	/**
	 * Service method to remove course
	 * @param id
	 * @return
	 * @throws InvalidCourseException
	 */
	boolean removeCourse(int id) throws InvalidCourseException;
	/**
	 * Service method to save faculty SkillSet
	 * @param faculty
	 * @return
	 * @throws FacultyDoesNotExist
	 */
	int saveFacultySkillset(Faculty faculty) throws FacultyDoesNotExist;

}
