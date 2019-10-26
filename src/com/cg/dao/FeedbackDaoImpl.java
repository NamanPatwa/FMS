package com.cg.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.Feedback;
import com.cg.bean.Participant;
import com.cg.exception.TrainingProgramNotFoundException;

public class FeedbackDaoImpl implements FeedbackDao {

	@Override
	public int persistFeedback(Feedback feed, Participant par) throws SQLException {
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
			stmt.setString(8,feed.getComments());
			stmt.setString(9,feed.getSuggestion());
		    stmt.executeUpdate();
			return 0;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		}finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}

	@Override
	public List<Participant> fetchAllTrainingCode(int participantId, int trainingcode) throws TrainingProgramNotFoundException, SQLException {
		Participant p=null;
		Connection conn = null;
        List<Participant> participant;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(getTrainingCodeQuery);
			stmt.setInt(1,trainingcode);
			stmt.setInt(2,participantId);	
			ResultSet result = stmt.executeQuery();
		
			participant=new ArrayList<Participant>();
			if(result.next()) {
				Participant par = new Participant();
				par.setTrainingcode(result.getInt(1));
				par.setParticipantId(result.getInt(2));
				participant.add(par);
			}
			if (participant.size() == 0) {
				throw new TrainingProgramNotFoundException();
				}
			return participant;
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
