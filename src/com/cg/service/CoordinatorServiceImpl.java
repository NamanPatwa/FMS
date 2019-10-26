package com.cg.service;

import java.sql.Date;
import java.util.List;

import com.cg.bean.Participant;
import com.cg.bean.TrainingProgram;
import com.cg.dao.CourseMasterDao;
import com.cg.dao.CourseMasterDaoImpl;
import com.cg.dao.EmployeeDao;
import com.cg.dao.EmployeeDaoImpl;
import com.cg.dao.FacultyDao;
import com.cg.dao.FacultyDaoImpl;
import com.cg.dao.ParticipantDao;
import com.cg.dao.ParticipantDaoImpl;
import com.cg.dao.TrainingProgramDao;
import com.cg.dao.TrainingProgramDaoImpl;
import com.cg.exception.FacultyDoesNotExist;
import com.cg.exception.InvalidCourseException;
import com.cg.exception.ParticipantNotFoundException;
import com.cg.exception.TrainingProgramNotFoundException;

public class CoordinatorServiceImpl implements CoordinatorService {
	
	private TrainingProgramDao trainingProgramDao;
	private EmployeeDao employeeDao;
	private ParticipantDao participantDao;
	private CourseMasterDao courseDao;
	private FacultyDao facultyDao;
	
	public CoordinatorServiceImpl() {
		trainingProgramDao = new TrainingProgramDaoImpl();
		employeeDao = new EmployeeDaoImpl();
		participantDao = new ParticipantDaoImpl();
		facultyDao = new FacultyDaoImpl();
		courseDao = new CourseMasterDaoImpl();
	}
	
	@Override
	public List<TrainingProgram> fetchAllTrainingProgram() throws TrainingProgramNotFoundException {
		return trainingProgramDao.fetchAllTrainingProgram();
	}

	@Override
	public TrainingProgram fetchTrainingProgramByTrainingCode(int code) throws TrainingProgramNotFoundException {
		return trainingProgramDao.fetchTrainingProgramByTrainingCode(code);
	}

	@Override
	public int updateTrainingProgram(TrainingProgram training) throws TrainingProgramNotFoundException {
		return trainingProgramDao.updateTrainingProgram(training);
	}

	@Override
	public boolean removeTrainingProgram(int code) throws TrainingProgramNotFoundException {
		return trainingProgramDao.removeTrainingProgram(code);
	}

	@Override
	public Participant addParticipant(Participant participant) throws ParticipantNotFoundException {
		if(employeeDao.checkParticipant(participant.getParticipantId())) {
			System.out.println("aaya");
			if(!participantDao.checkIfEnrolled(participant.getTrainingcode(), participant.getParticipantId())) {
				System.out.println("service me");
				java.util.Date date =  new java.util.Date();
				System.out.println("date me");
				Date currentDate = new Date(date.getTime());
				System.out.println("date ke bad");

				Date courseDate = trainingProgramDao.getTrainingDate(participant.getTrainingcode());
				System.out.println("badmehi");

				java.util.Date currentdate = new java.util.Date(currentDate.getTime());
				java.util.Date coursedate = new java.util.Date(courseDate.getTime());

			
				
				if(coursedate.after(currentdate)) {
					System.out.println("dateee");

					participantDao.addParticipant(participant);
					return participant;
				}else {
					System.out.println("Invalid Date");
					return null;
				} 
			} else {
				System.out.println("Already Enrolled in course");
				return null;
			}
		} else {
			System.out.println("Not a Participant");
			return null;
		}
	}

	@Override
	public TrainingProgram addTrainingProgram(TrainingProgram training) throws TrainingProgramNotFoundException, FacultyDoesNotExist, InvalidCourseException {
		System.out.println("bhot");

		if(courseDao.courseExist(training.getCourseCode())) {
			System.out.println("inside");
			if(facultyDao.isFaculty(training.getFacultyCode())) {
				System.out.println("in data");
				Date startDate = training.getStartDate();
				Date endDate = training.getEndDate();
				System.out.println(training);
				java.util.Date startdate = new java.util.Date(startDate.getTime());
				java.util.Date enddate = new java.util.Date(endDate.getTime());
				java.util.Date currdate = new java.util.Date();
				System.out.println("out");
				if(currdate.before(startdate))
				{
					if(startdate.before(enddate)) {
						trainingProgramDao.addTraining(training);
					} else {
						System.out.println("Start date cannot be greater than end date");
						return null;
					}
	
				} else {
					System.out.println("Date should be affter");
				}
				
			} else {
				System.out.println("Not a Faculty");
				return null;
			}
		} else {
			System.out.println("Course code does not exist");
			return null;
		}
		return null;
	}

	@Override
	public boolean validateDate(String date) {
		boolean val =  date.matches(validateDate);
		if(val == false)
			System.out.println("Invalid Date");
		return val;
	}

}
