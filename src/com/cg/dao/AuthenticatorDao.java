package com.cg.dao;

import com.cg.bean.EmployeeMaster;

/**
 * FMS - Authenticator Dao
 * @version 1.0
 * This is DAO class for FMS DAO authenticator
 */

public interface AuthenticatorDao {
	
	String save = "insert into employee_master values (?,?,?,?,?)";
	String get = "select * from employee_master where employee_id = ?";
	
	
	boolean addUser(EmployeeMaster employee);
	
	EmployeeMaster getInfo(int employeeId);
	
}
