package com.cg.client;

import java.util.Scanner;

import com.cg.bean.Faculty;
import com.cg.exception.FacultyDoesNotExist;
import com.cg.service.FacultyService;
import com.cg.service.FacultyServiceImpl;

public class FacultyCli {

	private static Scanner console;
	static {
		console = new Scanner(System.in);
	}

	public static void main(String[] args) {
		int option = 0;
		
		while(true) {
			System.out.println("1-Add Faculty details.");
			System.out.println("2-Update Faculty details by faculty id.");
			System.out.println("3-System Exit.");
			option = console.nextInt();
			
			switch(option) {
			case 1: addFacultyDetails(); break;
			case 2: updateFacultyDetails(); break;
			case 3: System.exit(0);
			default: System.out.println("Please add valid information..");
			}
		}
	}

	private static void updateFacultyDetails() {
		
	}

	private static void addFacultyDetails() {
		FacultyService service = new FacultyServiceImpl();
		String facultyId, skillset;
		
		do {
			System.out.println("Enter Faculty Id: ");
			facultyId = console.next();
		} while(!service.validateFacultyId(facultyId));
			
		do {
			System.out.println("Enter Faculty skillset: ");
			skillset = console.next();
		} while(!service.validateFacultySkillset(skillset));
					
		Faculty faculty = new Faculty();
//		String previousSkillset = faculty.getSkillSet();
//		System.out.println("previous skillset: " + previousSkillset);
//		String newSkillset = previousSkillset.concat(skillset);
//		System.out.println("new skillset: " + newSkillset);
//		
		faculty.setFacultyId(Integer.parseInt(facultyId));
		faculty.setSkillSet(skillset);
		
		try {
			int id = service.saveFacultySkillset(faculty);
			System.out.println("Faculty details are saved with id: " + id);
		} catch (FacultyDoesNotExist e) {
			System.out.println("Faculty details are not saved..");
		}
		
		
	}
}
