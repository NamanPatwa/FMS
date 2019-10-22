package com.cg.dao;


import java.util.List;

import com.cg.bean.TrainingProgram;
import com.cg.exception.TrainingProgramNotFoundException;

public interface TrainingProgramDao {
	String fetchAllTrainingProgram = "SELECT * from TRAINING_MASTER ";
	String fetchTrainingProgramByTrainingCode = "SELECT * from TRAINING_MASTER " + "where= TRAINING_CODE=?";
	String updateTrainingProgram = "UPDATE TRAINING_MASTER SET FACULTY_CODE=?, COURSE_CODE=?, START_DATE = ?, END_DATE = where TRAINING_CODE=?";
	String removeTrainingProgram = "DELETE from TRAINING_MASTER where TRAINING_CODE=?";
	String addTrainingProgram = "INSERT INTO TRAINING_MASTER VALUES (trainingcode_seq.nextval, ?, ?, ?, ?)";
	String getTrainingCode = "SELECT trainingcode_seq.currval FROM DUAL";
    
	List<TrainingProgram> fetchAllTrainingProgram() throws TrainingProgramNotFoundException;
	
	TrainingProgram fetchTrainingProgramByTrainingCode(int code) throws TrainingProgramNotFoundException;
	
	TrainingProgram updateTrainingProgram(int code) throws TrainingProgramNotFoundException;
	
	boolean removeTrainingProgram(int code) throws TrainingProgramNotFoundException;

	int addTraining(TrainingProgram training) throws TrainingProgramNotFoundException;
	
}
