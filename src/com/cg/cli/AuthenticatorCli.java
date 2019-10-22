package com.cg.cli;

import java.util.Scanner;

import com.cg.bean.EmployeeMaster;
import com.cg.service.AuthenticatorService;
import com.cg.service.AuthenticatorServiceImpl;

public class AuthenticatorCli {

	private AuthenticatorService service;
	private static Scanner console;

	static {
		console = new Scanner(System.in);
	}

	public AuthenticatorCli() {
		service = new AuthenticatorServiceImpl();
	}

	public static void main(String[] args) {
		int option = 0;

		while (true) {
			System.out.println("Enter Option");
			System.out.println("1 - signup 2- login 3- exit");
			option = console.nextInt();
			switch (option) {
			case 1: signup();
				break;
			case 2: login();
				break;
			case 4: System.exit(0);
			default: System.out.println("Please enter correct option");
			}
		}
	}
	
	
	private static void login() {
		AuthenticatorService service = new AuthenticatorServiceImpl();
		int employeeId;
		String password;
		
		System.out.println("Enter Employee ID");
		employeeId = console.nextInt();
		System.out.println("Enter Password");
		password = console.next();
		
		EmployeeMaster employee = service.authenticateUser(employeeId, password);
		
		switch (employee.getRole()) {
		case "Participant": new ParticipantCli().participantView(employee);
			break;
		case "Admin": new AdminCli().AdminView(employee);
			break;
		case "Co-Ordinator": new CoOrdinatorCli().coordinatorView(employee);
		}
	}

	private static void signup() {
		AuthenticatorService service = new AuthenticatorServiceImpl();
		
		System.out.println("Enter Employee ID");
		int employeeId = console.nextInt();
		
		System.out.println("Enter Name");
		String name = console.next();
		
		System.out.println("Enter Password");
		String password = console.next();
		
		int option;
		String role = null;
		
		while (true) {
			System.out.println("Enter Role");
			System.out.println("1 - Participant 2- Co-Ordinator 3- Admin 4- Exit");
			option = console.nextInt();
			switch (option) {
			case 1: role = "Participant";
				break;
			case 2: role = "Co-Ordinator";
				break;
			case 3: role = "Admin";
				break;
			case 4: System.exit(0);
			default:{
				System.out.println("Please enter correct option");
				continue;
			}
			}
			break;
			
		}
		service.addUser(employeeId, name, password, role);
		System.out.println("Employee Added Successfully");
	}
}
	

