package com.cg.service;

import com.cg.bean.EmployeeMaster;
/**
 *@version 1
 *Date Oct 8 2019
 *This is authenticator sevice interface having regex validation,authentication and add operation
 */
public interface AuthenticatorService {
	
	String validateEmployeeId = "[0-9]{2,}";
	/**
	 * Method to validate Employee Id
	 * @param employeeId
	 * @return boolean
	 */
	boolean validateEmployeeId(String employeeId);
	/**
	 * Service Method to Authenticate user
	 * @param employeeId
	 * @param password
	 * @return EmployeeMaster
	 */
	EmployeeMaster authenticateUser(int employeeId, String password);
	/**
	 * Service method to add user
	 * @param employeeId
	 * @param name
	 * @param password
	 * @param role
	 * @return
	 */
	boolean addUser(int employeeId, String name, String password, String role);
}
