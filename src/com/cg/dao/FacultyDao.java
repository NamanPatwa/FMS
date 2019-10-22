package com.cg.dao;

import com.cg.bean.Faculty;
import com.cg.exception.FacultyDoesNotExist;

public interface FacultyDao {

	String saveFacultySkillsetQuery = "UPSERT INTO faculty_skill VALUES(?,?)";
	String fetchFacultyIdQuery = "SELECT * FROM employee_master WHERE employee_id=?";
	
	int addFacultySkill(Faculty faculty) throws FacultyDoesNotExist;

}
