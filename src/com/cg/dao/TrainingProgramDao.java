package com.cg.dao;

import java.util.List;

import com.cg.bean.TrainingProgram;
import com.cg.exception.TrainingProgramNotFoundException;

public interface TrainingProgramDao {
	String fetchAllTrainingProgramQuery = "SELECT * from TRAINING_MASTER ";
	String fetchTrainingProgramByTrainingCodeQuery = "SELECT * from TRAINING_MASTER " + "where= TRAINING_CODE=?";
	String updateTrainingProgramQuery = "UPDATE TRAINING_MASTER SET FACULTY_CODE=?, "
			+ "COURSE_CODE=?, START_DATE = ?, END_DATE = where TRAINING_CODE=?";
	String removeTrainingProgramQuery = "DELETE from TRAINING_MASTER where TRAINING_CODE=?";
	
    List<TrainingProgram> fetchAllTrainingProgram() throws TrainingProgramNotFoundException;
	
	TrainingProgram fetchTrainingProgramByTrainingCode(int code) throws TrainingProgramNotFoundException;
	
	TrainingProgram updateTrainingProgram(int code) throws TrainingProgramNotFoundException;
	
	boolean removeTrainingProgram(int code) throws TrainingProgramNotFoundException;
	
	
}
