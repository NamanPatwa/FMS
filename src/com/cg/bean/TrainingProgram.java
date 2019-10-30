package com.cg.bean;

import java.sql.Date;
/**
 * @version 1
 * Date Sep 26 2019
 * This is a Training Programme bean class having all elements of Training Programme Master
 */
public class TrainingProgram {
	private int trainingCode;
	private int courseCode;
	private int facultyCode;
	private Date startDate;
	private Date endDate;
	/**
	 * Default Constructor
	 */
	public TrainingProgram() {
	}
	/**
	 * Non Default Constructor
	 * @param trainingCode Unique code for each training programme
	 * @param courseCode unique code for each course
	 * @param facultyCode unique code for each faculty
	 * @param startDate Start date of course
	 * @param endDate End Date of course
	 */
	public TrainingProgram(int trainingCode, int courseCode, int facultyCode, Date startDate, Date endDate) {
		super();
		this.trainingCode = trainingCode;
		this.courseCode = courseCode;
		this.facultyCode = facultyCode;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * Method to get Training code
	 * @return trainingCode(Integer)
	 */
	public int getTrainingCode() {
		return trainingCode;
	}
	/**
	 * Set the Training code
	 * @param trainingCode(Integer)
	 */
	public void setTrainingCode(int trainingCode) {
		this.trainingCode = trainingCode;
	}
	/**
	 * method to get the course code
	 * @return courseCode(Integer)
	 */
	int getCourseCode() {
		return courseCode;
	}
	/**
	 * Set the course code
	 * @param courseCode(Integer)
	 */
	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}
	/**
	 * Method to get the faculty code
	 * @return facultyCode(integer)
	 */
	public int getFacultyCode() {
		return facultyCode;
	}
	/**
	 * Method to set the faculty code
	 * @param facultyCode(Integer)
	 */
	public void setFacultyCode(int facultyCode) {
		this.facultyCode = facultyCode;
	}
	/**
	 * Method to get the start date
	 * @return startDate(Date)
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * Set The Start date
	 * @param startDate(Date)
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * Method to get the end date 
	 * @return endDate(Date)
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * Set the End Date
	 * @param endDate(Date)
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Training Code: " + trainingCode + " Course Code: " + courseCode + " Faculty Code: "
				+ facultyCode + " Start Date: " + startDate + " End Date: " + endDate ;
	}	
}
