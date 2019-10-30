package com.cg.bean;

import java.util.List;
/**
 * @version 1
 * Date Sep 27 2019
 * This is a Feedback bean class having all elements of Feedback_Master
 */
public class Faculty {
	private int facultyId;
	private String skillSet;
	/**
	 * Default Constructor
	 */
	public Faculty() {
	}
	/**
	 * Non Default Constructor
	 * @param facultyId unique id for each faculty
	 * @param skillSet list of skill for each faculty
	 */
	public Faculty(int facultyId, String skillSet) {
		super();
		this.facultyId = facultyId;
		this.skillSet = skillSet;
	}
	/**
	 * Method to get Faculty Id
	 * @return facultyId(Integer)
	 */

	public int getFacultyId() {
		return facultyId;
	}
	/**
	 * Set the faculty id
	 * @param facultyId(Integer)
	 */
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	/**
	 * Method to get list of skill of faculty
	 * @return skillSet(String)
	 */
	public String getSkillSet() {
		return skillSet;
	}
	/**
	 * Set the skillset of faculty
	 * @param skillSet(String)
	 */
	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}
	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", skillSet=" + skillSet + "]";
	}
	
	
	
}
