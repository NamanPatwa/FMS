package com.cg.dao;

import com.cg.bean.Feedback;
import com.cg.bean.Participant;
import com.cg.exception.TrainingProgramNotFoundException;

public interface FeedbackDao {
	
	String saveFeedbackQuery = "INSERT INTO FEEDBACK_MASTER VALUES(?,?,?,?,?,?,?)";
	
	int persistFeedback(Feedback feed, Participant par) throws TrainingProgramNotFoundException;
	
	
}
