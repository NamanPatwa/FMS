package com.cg.dao;

import java.sql.SQLException;
import java.util.List;

import com.cg.bean.Feedback;
import com.cg.bean.Participant;
import com.cg.exception.TrainingProgramNotFoundException;

public interface FeedbackDao {
	
	String saveFeedbackQuery = "INSERT INTO FEEDBACK_MASTER VALUES(?,?,?,?,?,?,?,?,?)";
	String getTrainingCodeQuery = "select * from  Training_Participant_Master where Training_code=? and Participant_id=?";
	
	int persistFeedback(Feedback feed, Participant par) throws SQLException;
    List<Participant> fetchAllTrainingCode(int participantId, int trainingcode) throws TrainingProgramNotFoundException, SQLException;
	
	
}
