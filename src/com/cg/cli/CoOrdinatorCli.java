package com.cg.cli;

import java.util.List;
import java.util.Scanner;

import com.cg.bean.EmployeeMaster;
import com.cg.bean.TrainingProgram;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.service.CoordinatorService;
import com.cg.service.CoordinatorServiceImpl;

public class CoOrdinatorCli {
	private static CoordinatorService service;
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
			System.out.println("4 - Show Training Program by Training Code");
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
		int code = 0;
		System.out.println("Enter Course Code: ");
		code = console.nextInt();
		try {
			service.removeTrainingProgram(code);
			System.out.println("Training Program Removed Successfully");
		} catch (TrainingProgramNotFoundException e) {
			System.out.println("Training Code Not Found !!");
		}
		
	}	

	private static void updateTrainingProgram() {
		// TODO Auto-generated method stub

	}

	private static void showTrainingProgramById() {
		int code = 0;
		System.out.println("Enter Training Id: ");
		code = console.nextInt();
		try {
			TrainingProgram result = service.fetchTrainingProgramByTrainingCode(code);
			System.out.println(result.toString());
		} catch (TrainingProgramNotFoundException e) {
			System.out.println("Training Program is not Found");
			e.printStackTrace();
		}

	}

	private static void showAllTrainingProgram() {

		try {
			List<TrainingProgram> result = service.fetchAllTrainingProgram();
			for (TrainingProgram t : result) {
				System.out.println(t.toString());
			}
		} catch (TrainingProgramNotFoundException e) {
			System.out.println("No Training Program exists for the moment..Sorry!");
			e.printStackTrace();
		}

	}

	private static void addTrainingProgram() {
		// TODO Auto-generated method stub

	}

	private static void addParticipant() {
		// TODO Auto-generated method stub

	}

}
