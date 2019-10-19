package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.bean.Participant;
import com.cg.exception.ParticipantNotFoundException;

public class ParticipantDaoImpl implements ParticipantDao {

	@Override
	public int addParticipant(Participant participant) throws ParticipantNotFoundException {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(addParticipantQuery);
			stmt.setInt(1, participant.getTrainingcode());
			stmt.setInt(2, participant.getParticipantId());
			
			int update = stmt.executeUpdate();
			if(update == 1)
				return participant.getParticipantId();
			else 
				return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ParticipantNotFoundException();
		} finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public Participant findParticipantByTrainingCode(int trainingCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Participant findParticipantByParticipantCode(int participantCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteParticipantByTrainingCode(int trainingCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteParticipantByParticipantId(int participantCode) {
		// TODO Auto-generated method stub
		return false;
	}

}
