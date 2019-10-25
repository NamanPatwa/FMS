package com.cg.cli;

import java.util.Scanner;

import com.cg.bean.EmployeeMaster;
import com.cg.service.CoordinatorService;
import com.cg.service.CoordinatorServiceImpl;

public class CoOrdinatorCli {
	private CoordinatorService service;
	private static Scanner console;

	void coordinatorView(EmployeeMaster employee) {
		System.out.println("Co-Ordinator -- Welcome");
		System.out.println(employee);
	}

	static {
		console = new Scanner(System.in);
	}

	public CoOrdinatorCli() {
		service = new CoordinatorServiceImpl();
	}

	public static void main(String[] args) {
		int option = 0;

		while (true) {
			System.out.println("Enter Option");
			System.out.println("1 - Add Participant");
			System.out.println("2 - Add Training Program");
			System.out.println("3 - Show All Training Program");
			System.out.println("4 - Show Training Program by ID");
			System.out.println("5 - Update Training Program");
			System.out.println("6 - Remove Training Program");
			System.out.println("7 - Exit");
			
			option = console.nextInt();
			switch (option) {
			case 1:
				addParticipant();
				break;
			case 2:
				addTrainingProgram();
				break;
			case 3:
				showAllTrainingProgram();
				break;
			case 4:
				showTrainingProgramById();
				break;
			case 5:
				updateTrainingProgram();
				break;
			case 6:
				removeTrainingProgram();
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("Please enter correct option");
			}
		}
	}

	private static void removeTrainingProgram() {
		// TODO Auto-generated method stub
		
	}

	private static void updateTrainingProgram() {
		// TODO Auto-generated method stub
		
	}

	private static void showTrainingProgramById() {
		// TODO Auto-generated method stub
		
	}

	private static void showAllTrainingProgram() {
		// TODO Auto-generated method stub
		
	}

	private static void addTrainingProgram() {
		// TODO Auto-generated method stub
		
	}

	private static void addParticipant() {
		// TODO Auto-generated method stub
		
	}

}
