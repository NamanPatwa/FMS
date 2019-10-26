package com.cg.cli;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.cg.bean.EmployeeMaster;
import com.cg.bean.Participant;
import com.cg.bean.TrainingProgram;
import com.cg.exception.FacultyDoesNotExist;
import com.cg.exception.InvalidCourseException;
import com.cg.exception.ParticipantNotFoundException;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.service.CoordinatorService;
import com.cg.service.CoordinatorServiceImpl;

public class CoOrdinatorCli {
	private static CoordinatorService service;
	private static Scanner console;
	
	public CoOrdinatorCli() {
		service = new CoordinatorServiceImpl();
	}
	void coordinatorView(EmployeeMaster employee) {
		System.out.println("Co-Ordinator -- Welcome");
		System.out.println(employee);
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

	static {
		console = new Scanner(System.in);
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
		String startDate, endDate;
		TrainingProgram tp = new TrainingProgram();
		System.out.println("Enter Training Code:");
		tp.setTrainingCode(console.nextInt());
		System.out.println("Enter Course Code");
		tp.setCourseCode(console.nextInt());
		System.out.println("Enter Faculty Code :");
		tp.setFacultyCode(console.nextInt());
		
		do{
			System.out.println("Enter Start Date");
			startDate = console.next();
		} while (!service.validateDate(startDate));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date sdate;
		try {
			sdate = sdf.parse(startDate);
			System.out.println(sdate);
			Date sDate = new Date(sdate.getTime());
			tp.setStartDate(sDate);
			System.out.println(sDate);
		} catch (ParseException e1) {
			System.out.println("Invalid Date Format");
			e1.printStackTrace();
		}
		
		
		do {
		System.out.println("Enter End Date");
		endDate = console.next();
		} while (!service.validateDate(endDate));
		
		try {
			java.util.Date edate = sdf.parse(endDate);
			Date eDate = new Date(edate.getTime());
			tp.setEndDate(eDate);
		} catch (ParseException e1) {
			System.out.println("Invalid Date Format");
		}
		
		try {
			service.addTrainingProgram(tp);
			System.out.println("Training Added Successfully");
		} catch (TrainingProgramNotFoundException e) {
			System.out.println("Training Program Does Not Exists");
		} catch (FacultyDoesNotExist e) {
			System.out.println("Faculty Does Not Exist");
		} catch (InvalidCourseException e) {
			System.out.println("Invalid Course Code");
		}
	}

	private static void addParticipant() {
		Participant participant = new Participant();
		
		System.out.println("Enter Training Code");
		participant.setTrainingcode(console.nextInt());
		
		System.out.println("Enter Participant ID");
		participant.setParticipantId(console.nextInt());
		System.out.println(participant);
		try {
			service.addParticipant(participant);
		} catch (ParticipantNotFoundException e) {
			System.out.println("Participant Does Not Exist Or Already ENrolled");
		}
		
	}
}
