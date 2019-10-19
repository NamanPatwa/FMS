package com.cg.dao;

import com.cg.bean.TrainingProgram;

public interface TrainingProgramDao {
	
	String addtraining = "INSERT INTO TRAINING_MASTER VALUES (trainingcode_seq.nextval, ?, ?, ?, ?)";
	String findtraining = "SELECT * FROM TRAINING_MASTER WHERE TRAINING_CODE = ?";
	String deletetraining = "SELECT * FROM TRAINIG_MASTER WHERE TRAINING_CODE = ?";
	String updatetraining = "DELETE FROM TRAINING MASTER WHERE TRAINING_CODE = ?";
	
	
	int addTraining(TrainingProgram training);
	
	TrainingProgram fetchTraining(int trainingCode);
	
	boolean deleteTraining(int trainingCode);
	
	int updateTraining(TrainingProgram training);
	
}
