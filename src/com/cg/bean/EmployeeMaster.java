package com.cg.bean;
/**
 * @author Isha Yadav
 * @version 1
 * Date Sep 27 2019
 * This is a Feedback bean class having all elements of Feedback_Master
 */
public class EmployeeMaster {
	private int employeeId;
	private String employeeName;
	private String password;
	private String role;
	private String userSalt;
	/**
	 * Default Constructor
	 */
	public EmployeeMaster() {
	}
	/**
	 * 
	 * @param employeeId unique ID for each employee
	 * @param employeeName name of the employee
	 * @param password Password for employee
	 * @param role role of the employee
	 * @param userSalt random data for encryption
	 */
	
	public EmployeeMaster(int employeeId, String employeeName, String password, String role, String userSalt) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
		this.role = role;
		this.userSalt = userSalt;
	}
	/**
	 * Method to get user salt
	 * @return userSalt(String)
	 */
	public String getUserSalt() {
		return userSalt;
	}
	/**
	 * Set the user salt
	 * @param userSalt(String)
	 */
	public void setUserSalt(String userSalt) {
		this.userSalt = userSalt;
	}
	/**
	 * Method to get the employee id 
	 * @return employeeId(Integer)
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	/**
	 * Set the employee Id
	 * @param employeeId (Integer)
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * Method to get Employee name
	 * @return employeeName(String)
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * Set the Employee Name
	 * @param employeeName(String)
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/**
	 * Method to get Password of employee
	 * @return password (string)
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Set the password of employee
	 * @param password(String)
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * method to get role of employee
	 * @return role(String)
	 */
	public String getRole() {
		return role;
	}
	/**
	 * Set the role of employee
	 * @param role(string)
	 */
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "EmployeeMaster [employeeId=" + employeeId + ", employeeName=" + employeeName + ", password=" + password
				+ ", role=" + role + "]";
	}
	
}
