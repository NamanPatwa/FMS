package com.cg.service;

import java.util.Date;
import java.util.List;

import com.cg.bean.Participant;
import com.cg.bean.TrainingProgram;
import com.cg.dao.CourseMasterDao;
import com.cg.dao.EmployeeDao;
import com.cg.dao.EmployeeDaoImpl;
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
	
	public CoordinatorServiceImpl() {
		trainingProgramDao = new TrainingProgramDaoImpl();
		employeeDao = new EmployeeDaoImpl();
		participantDao = new ParticipantDaoImpl();
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
			if(participantDao.checkIfEnrolled(participant.getTrainingcode(), participant.getParticipantId())) {
				Date currentDate = new Date();
				Date courseDate = trainingProgramDao.getTrainingDate(participant.getParticipantId());
				if(currentDate.after(courseDate)) {
					participantDao.addParticipant(participant);
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
		return null;
	}

	@Override
	public TrainingProgram addTrainingProgram(TrainingProgram training) throws TrainingProgramNotFoundException, FacultyDoesNotExist, InvalidCourseException {
		if(courseDao.fetchCourseByCourseId(training.getCourseCode()) != null) {
			if(employeeDao.checkFaculty(training.getFacultyCode())) {
				if(training.getStartDate().before(training.getEndDate())) {
					trainingProgramDao.addTraining(training);
				} else {
					System.out.println("Start date cannot be greater than end date");
					return null;
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

}
