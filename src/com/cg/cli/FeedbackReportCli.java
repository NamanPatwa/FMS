package com.cg.cli;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.bean.FeedbackReport;
import com.cg.exception.FeedbackNotFoundException;
import com.cg.service.FeedbackReportService;
import com.cg.service.FeedbackReportServiceImpl;
/**
 * @version 1
 * Date Oct 28 2019
 * This is a FeedbackReportCli which has functionality to get feedback for any month any faculty
 */
public class FeedbackReportCli {
	
	private static FeedbackReportService feedbackService;
	private static Scanner console;
	
	static {
		feedbackService = new FeedbackReportServiceImpl();
		console = new Scanner(System.in);
	}
	/**
	 * This is FeedbackReportView Method which gives report of feeback
	 */
	void feedbackReportView() {
		System.out.println("Welcome -- Feedback Reports Page");
		
		int option = 0;
		
		while(true) {
			do {
				try {
					System.out.println("Enter Feedback Category :");
					System.out.println("1 - Feedback Reports of Month");
					System.out.println("2 - Feedback Reports by Faculty for month");
					System.out.println("3 - Feedback Defaulters of the month");
					System.out.println("4 - Return to Previous Page");
					option = console.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid Input");
				}
				console.nextLine();
			} while (option < 0);
			
			switch(option) {
				case 1: feedbackByMonth();	break;
				case 2: feedbackByFaculty(); break;
				case 3: feedbackDeafulters(); break;
				case 4: break;
				default : System.out.println("Invalid Selection Please Enter Again");
			} if(option == 4)break;
		}
	}
	/**
	 * This is a Method which gives report of feedback Defaulters
	 */
	private static void feedbackDeafulters() {
		System.out.println("Enter Month ");
		int month = console.nextInt();
		try {
			List<FeedbackReport> feedbacks = feedbackService.getDefaultersByMonth(month);
			System.out.println("Start_Date \t End_Date\t Training_Code \t Faculty_Name \t Participant_Name \t Pres_&_Comm \t Clarify_Doubts \t TM \t Handouts \t H/w_S/w_N/w");
			for (FeedbackReport feedback : feedbacks) {
				System.out.println(feedback);
			}
		} catch (FeedbackNotFoundException e) {
			System.out.println("No Feedback Defaulters for entered month");
		}
	}
	/**
	 * method to get feedbackBy faculty
	 */
	private static void feedbackByFaculty() {
		System.out.println("Enter Faculty Code");
		int facultyCode = console.nextInt();
		System.out.println("Enter Month");
		int month = console.nextInt();
		try {
			List<FeedbackReport> feedbacks = feedbackService.getByFacultyForMonth(facultyCode, month);
			System.out.println("Start_Date \t End_Date\t Training_Code \t Faculty_Name \t Participant_Name \t Pres_&_Comm \t Clarify_Doubts \t TM \t Handouts \t H/w_S/w_N/w");
			for (FeedbackReport feedback : feedbacks) {
				System.out.println(feedback);
			}
			System.out.println(feedbackService.getAvgByMonthAndFaculty(month, facultyCode));
		} catch (FeedbackNotFoundException e) {
			System.out.println("No Feedbacks Found For Given Criteria");
		}
	}
	/**
	 * Method to get feedback by month
	 */
	private static void feedbackByMonth() {
		System.out.println("Enter Month");
		int month = console.nextInt();
		try {
			List<FeedbackReport> feedbacks = feedbackService.getByMonth(month);
			System.out.println("Start_Date \t End_Date\t Training_Code \t Faculty_Name \t Participant_Name \t Pres_&_Comm \t Clarify_Doubts \t TM \t Handouts \t H/w_S/w_N/w");
			for (FeedbackReport feedback : feedbacks) {
				System.out.println(feedback);
			}
			System.out.println(feedbackService.getAvgByMonth(month));
		} catch (FeedbackNotFoundException e) {
			System.out.println("No Feedbacks Found For Given Criteria");
		}
	}
}
