package com.cg.service;

import com.cg.bean.Faculty;
import com.cg.dao.FacultyDao;
import com.cg.dao.FacultyDaoImpl;
import com.cg.exception.FacultyDoesNotExist;

public class FacultyServiceImpl implements FacultyService {

	private FacultyDao dao;
	
	public FacultyServiceImpl() {
		dao = new FacultyDaoImpl();
	}
	
	@Override
	public int saveFacultySkillset(Faculty faculty) throws FacultyDoesNotExist {
		return dao.addFacultySkill(faculty);
	}

}
