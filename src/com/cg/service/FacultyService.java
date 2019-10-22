package com.cg.service;

import com.cg.bean.Faculty;
import com.cg.exception.FacultyDoesNotExist;

public interface FacultyService {

	String idRule = "[0-9]{1,}";
	String skillsetRule = "[A-Z][a-z]{1,}";
	
	default boolean validateFacultyId(String facultyId) {
		return facultyId.matches(idRule);
	}
	
	default boolean validateFacultySkillset(String skillset) {
		return skillset.matches(skillsetRule);
	}
	
	
	int saveFacultySkillset(Faculty faculty) throws FacultyDoesNotExist;
}
