package com.cg.dao;

import java.util.List;

import com.cg.bean.Feedback;
import com.cg.bean.Participant;
import com.cg.exception.FacultyDoesNotExist;
import com.cg.exception.FeedbackMasterNotExist;
import com.cg.exception.TrainingProgramNotFoundException;
/**
 * FMS - Feedback Dao
 * @version 1.0
 * This is DAO interface for Feedback
 */
public interface FeedbackDao {
	
	String saveFeedbackQuery = "INSERT INTO FEEDBACK_MASTER VALUES(?,?,?,?,?,?,?,?,?)";
	String getTrainingCodeQuery = "select * from Training_Participant_Master where Training_code=? and Participant_id=?";
	/**
	 * 
	 * @param feed
	 * @param par
	 * @return
	 * @throws FeedbackMasterNotExist
	 */
	int persistFeedback(Feedback feed, Participant par)throws FeedbackMasterNotExist;
	/**
	 * 
	 * @param participantId
	 * @param trainingcode
	 * @return
	 * @throws TrainingProgramNotFoundException
	 */
    List<Participant> fetchAllTrainingCode(int participantId, int trainingcode) throws TrainingProgramNotFoundException;
	
	
}
