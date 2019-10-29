package com.cg.cli;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.cg.bean.EmployeeMaster;
import com.cg.bean.Feedback;
import com.cg.bean.Participant;
import com.cg.exception.TrainingProgramNotFoundException;
import com.cg.service.ParticipantService;
import com.cg.service.ParticipantServiceImpl;

public class ParticipantCli {
	private static Scanner console;
    int participantId;
    int trainingcode;
	private List<Participant> trcode;
	static {
		console = new Scanner(System.in);
	}
	
	void participantView(EmployeeMaster employee) throws InterruptedException, TrainingProgramNotFoundException, SQLException {
		participantId =employee.getEmployeeId();
		fetchTrainingCode();
		System.out.println(trcode);

		int option = 0;
		while (true) {
			
			do {
				try {
					System.out.println("Enter 1 to give Feedback");
					System.out.println("Enter 2 to Exit");
					option = console.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid Input");
				}
					console.nextLine();
			} while (option < 0);
			
			switch (option) {
			case 1:
				addFeedback();
				break;
			case 2:
				System.exit(0);
			default:
				System.out.println("Please Enter valid Key");
			}
		}
	}
	private void fetchTrainingCode() throws TrainingProgramNotFoundException,InterruptedException, SQLException {
		ParticipantService service = new ParticipantServiceImpl();
		int t = 0;
		int a=0;
		String trid=null;
		do {
			try {
				System.out.println("Training code should be number having minimum 2 and maximum 5 digit");
				do {
					if(a>0) {
						System.out.println("You have entered wrong traing code Please follow the instruction");
						TimeUnit.SECONDS.sleep(2);
						System.out.println("Enter training code for which you want to give feedback again");
					    }
					else
						System.out.println("Enter training code for which you want to give feedback");
					    trid = console.next();
					    a++;
				}while(!service.validatetrainingcode(trid));
				trainingcode=Integer.parseInt(trid);
				trcode = service.getAllTrainingCode(participantId,trainingcode);
				t++;
			} catch (TrainingProgramNotFoundException e) {
				System.out.println("Either You have entered wrong Training code or u are not a part of that training which u have entered");
				TimeUnit.SECONDS.sleep(3);
			}
		} while (t != 1);

	}
	
	private void addFeedback() throws InterruptedException, SQLException {
		ParticipantService service = new ParticipantServiceImpl();
		String prs_cmm, clrfy_doubt, tm, hnd_out, hw_sw_ntwrk,comm,sugg;
		System.out.println(
				"Rules for grade \n5 For Excellent  4 For Good  3 For Average  2 For Bellow Average & 1 for Poor ");
		TimeUnit.SECONDS.sleep(4);
		
		int p = 0;
		do {
			if (p > 0) {
				System.out.println("You have not followed the rule please read above Instruction Carefully");
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Enter correct Grade for Presentation and communication skill");
			} else
				System.out.println("Enter Grade for Presentation and communication skill");
			prs_cmm = console.next();
			p++;
		} while (!service.validateprs_cmm(prs_cmm));
		
		int q = 0;
		do {
			if (q > 0) {
				System.out.println("You have not followed the rule please read above Instruction Carefully");
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Enter correct Grade for doubt Clarification");
			} else
				System.out.println("Enter Grade for doubt Clarrification ");
			clrfy_doubt = console.next();
			q++;
		} while (!service.validateclrfy_doubt(clrfy_doubt));
		
		int r = 0;
		do {
			if (r > 0) {
				System.out.println("You have not followed the rule please read above Instruction Carefully");
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Enter correct Grade for doubt Clarification");
			} else
				System.out.println("Enter Grade for Time Management ");
			tm = console.next();
			r++;
		} while (!service.validatetm(tm));
		
		int s = 0;
		do {
			if (s > 0) {
				System.out.println("You have not followed the rule please read above Instruction Carefully");
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Enter correct Grade for hand out given by trainers");
			} else
				System.out.println("Enter Grade for handout given by trainer ");
			hnd_out = console.next();
			s++;
		} while (!service.validatehnd_out(hnd_out));
		
		int t = 0;
		do {
			if (t > 0) {
				System.out.println("You have not followed the rule please read above Instruction Carefully");
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Enter correct Grade for hardware software and network provided during training");
			} else
				System.out.println("Enter Grade for hardware software and network provided during training ");
			hw_sw_ntwrk = console.next();
			t++;
		} while (!service.validatehw_sw_ntwrk(hw_sw_ntwrk));
		
		System.out.println("Comment and Suggestion Should be Minimum of 5 character and maximum of 200 ");
		TimeUnit.SECONDS.sleep(3);
		
		int u=0;
		do {
		   if(u>0) {
		    System.out.println("You have not followed Comment Rule Please Follow this ");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Enter Comments Regarding Training Programme Again");
		}else
			System.out.println("Enter Your Comments Regarding Training Programme");
			comm=console.next();
			u++;
		}while(!service.validatecomment(comm));
		
		int v=0;
		do {
		if(v>0){
			System.out.println("You have not followed Suggestion Rule Please Follow this ");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Enter Suggestion Regarding Training Programme and Trainer Again");
		}
		else
			System.out.println("Enter Your Suggestion Regarding Training Programme and Trainer");
			sugg=console.next();
		    v++;
		}while(!service.validatesuggestion(sugg));
		
		Participant par = new Participant();
		Feedback feed = new Feedback();

		feed.setDoubtClarification(Integer.parseInt(clrfy_doubt));
		feed.setHandout(Integer.parseInt(hnd_out));
		feed.setHwSwNwAvailability(Integer.parseInt(hw_sw_ntwrk));
		feed.setPresentationAndCommunication(Integer.parseInt(prs_cmm));
		feed.setTimeManagement(Integer.parseInt(tm));
		feed.setComments(comm);
		feed.setSuggestion(sugg);
		par.setTrainingcode(trainingcode);
		par.setParticipantId(participantId);
        service.saveFeedback(feed, par);
	}
	
}
