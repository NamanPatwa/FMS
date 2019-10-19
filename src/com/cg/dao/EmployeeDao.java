package com.cg.dao;

import com.cg.exception.FacultyDoesNotExist;

public interface EmployeeDao {
	
	String checkFaculty = "SELECT * FROM EMPLOYEE_MASTER WHERE EMPLOYEE_ID = ? AND ROLE = faculty";
	
	boolean checkRole(int employeeid) throws FacultyDoesNotExist;
	
}
