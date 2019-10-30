package com.cg.dao;

import com.cg.exception.FacultyDoesNotExist;
import com.cg.exception.ParticipantNotFoundException;
/**
 * FMS - Employee Dao
 * @version 1.0
 * This is DAO class for Employee
 */
public interface EmployeeDao {
	
	String checkFaculty = "SELECT * FROM EMPLOYEE_MASTER WHERE EMPLOYEE_ID = ? AND ROLE = faculty";
	String checkParticipant = "SELECT * FROM EMPLOYEE_MASTER WHERE EMPLOYEE_ID = ? AND ROLE = 'Participant'";
	/**
	 * 
	 * @param employeeid
	 * @return
	 * @throws FacultyDoesNotExist
	 */
	boolean checkFaculty(int employeeid) throws FacultyDoesNotExist;
	/**
	 * 
	 * @param employeeId
	 * @return
	 * @throws ParticipantNotFoundException
	 */
	boolean checkParticipant(int employeeId) throws ParticipantNotFoundException;
}
