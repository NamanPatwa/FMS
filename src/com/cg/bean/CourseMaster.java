package com.cg.bean;
/**
 * @version 1
 * Date Sep 26 2019
 * This is a Course master bean class having all elements of Course_Master
 */
public class CourseMaster {
	private int courseId;
	private String courseName;
	private int days;
	/**
	 * Default Constructor
	 */
	public CourseMaster() {
	}
	/**
	 * 
	 * @param courseId unique Id for each course
	 * @param courseName Name of the courses
	 * @param days no of days in which course will be completed
	 */
	public CourseMaster(int courseId, String courseName, int days) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.days = days;
	}
	/**
	 * Method to get course Id
	 * @return courseId(Integer)
	 */
	public int getCourseId() {
		return courseId;
	}
	/**
	 * Set the course Id
	 * @param courseId(Integer)
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	/**
	 * Method to get Course Name
	 * @return courseName(String)
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * Set the course Name
	 * @param courseName(String)
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * Method to get duration of course
	 * @return days(Integer)
	 */
	public int getDays() {
		return days;
	}
	/**
	 * Set the duration of courses
	 * @param days(Integer)
	 */
	public void setDays(int days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "Course ID: \t" + courseId + "\t, Course Name: \t" + courseName + "\t, Duration: \t" + days + " days";
	}
}
