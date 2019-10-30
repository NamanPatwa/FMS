package com.cg.service;

import java.util.List;

import com.cg.bean.Participant;
import com.cg.bean.TrainingProgram;
import com.cg.dao.ParticipantDao;
import com.cg.exception.FacultyDoesNotExist;
import com.cg.exception.InvalidCourseException;
import com.cg.exception.ParticipantNotFoundException;
import com.cg.exception.TrainingProgramNotFoundException;
/**
 * @version 1
 * Date Oct 12 2019
 * This is a coordinator service interface having regex validation and CRUD operation
 */
public interface CoordinatorService {
	
	String validateDate = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
	String facultyIdRule = "[0-9]{1,}";
	String trainingIdRule = "[0-9]{1,}";
	String courseIdRule = "[0-9]{1,}";
	/**
	 * Method to get list of all training programme
	 * @return List<TrainingProgram> 
	 * @throws TrainingProgramNotFoundException
	 */
	List<TrainingProgram> fetchAllTrainingProgram() throws TrainingProgramNotFoundException;
	/**
	 * Method to fetch training programme by training code
	 * @param code
	 * @return TrainingProgram
	 * @throws TrainingProgramNotFoundException
	 */
	TrainingProgram fetchTrainingProgramByTrainingCode(int code) throws TrainingProgramNotFoundException;
	/**
	 * method to update Training programme 
	 * @param training
	 * @return TrainingProgram
	 * @throws TrainingProgramNotFoundException
	 */
	TrainingProgram updateTrainingProgram(TrainingProgram training) throws TrainingProgramNotFoundException;
	/**
	 * Method to remove Training Programme
	 * @param code
	 * @return Boolean
	 * @throws TrainingProgramNotFoundException
	 */
	boolean removeTrainingProgram(int code) throws TrainingProgramNotFoundException;
	/**
	 * Method to add Participant
	 * @param participant
	 * @return Participant
	 * @throws ParticipantNotFoundException
	 */
	Participant addParticipant(Participant participant) throws ParticipantNotFoundException;
	/**
	 * Method to add Training Programme
	 * @param training
	 * @return
	 * @throws TrainingProgramNotFoundException
	 * @throws FacultyDoesNotExist
	 * @throws InvalidCourseException
	 */
	
	TrainingProgram addTrainingProgram(TrainingProgram training) throws TrainingProgramNotFoundException, FacultyDoesNotExist, InvalidCourseException;
	
	/**
	 * Method to validate Date
	 * @param date
	 * @return
	 */
	boolean validateDate(String date);
	/**
	 * Method to validate Faculty Id
	 * @param facultyid
	 * @return
	 */
	boolean validateFacultyId(String facultyid);
	/**
	 * Method to validate Training Id
	 * @param trainingId
	 * @return
	 */
	boolean validateTrainingId(String trainingId);
	/**
	 * Method to validate Course Id
	 * @param courseId
	 * @return
	 */
	boolean validateCourseId(String courseId);
}
