package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cg.bean.Feedback;
import com.cg.bean.Participant;
import com.cg.exception.TrainingProgramNotFoundException;

public class FeedbackDaoImpl implements FeedbackDao {

	@Override
	public int persistFeedback(Feedback feed, Participant par) throws TrainingProgramNotFoundException {
Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(saveFeedbackQuery);
			stmt.setInt(1,par.getTrainingcode());
			stmt.setInt(2,par.getParticipantId());
			stmt.setInt(3,feed.getPresentationAndCommunication());
			stmt.setInt(4,feed.getDoubtClarification());
			stmt.setInt(5,feed.getTimeManagement());
			stmt.setInt(6,feed.getHandout());
			stmt.setInt(7,feed.getHwSwNwAvailability());
		    stmt.executeUpdate();
			return 0;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new TrainingProgramNotFoundException(e.getMessage());
		}finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
}
