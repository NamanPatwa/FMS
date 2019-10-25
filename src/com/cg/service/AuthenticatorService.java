package com.cg.service;

import com.cg.bean.EmployeeMaster;

public interface AuthenticatorService {
	/*
	 * Reference Links :1. https://dev.to/awwsmm/how-to-encrypt-a-password-in-java-42dh
	 *					2. https://www.quickprogrammingtips.com/java/how-to-securely-store-passwords-in-java.html
	 */
	
	EmployeeMaster authenticateUser(int employeeId, String password);
	
	boolean addUser(int employeeId, String name, String password, String role);
}
