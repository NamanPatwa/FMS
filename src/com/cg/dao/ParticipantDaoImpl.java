package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.Participant;
import com.cg.exception.ParticipantNotFoundException;
import com.cg.exception.TrainingProgramNotFoundException;

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

	@Override
	public List<Participant> trainingByParticicpant(int participantCode) throws TrainingProgramNotFoundException {
		Participant p=null;
		Connection conn = null;
        List<Participant> participant;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(findTrainingByParticipant);
			stmt.setInt(1, participantCode);
			
			ResultSet result = stmt.executeQuery();
			participant=new ArrayList<Participant>();
			while (result.next()) {
				Participant par = new Participant();
				par.setTrainingcode(result.getInt(1));
				par.setParticipantId(result.getInt(2));
				participant.add(par);
			}
			if (participant.size() == 0) {
				throw new TrainingProgramNotFoundException();}
			return participant;
		} catch (SQLException e) {
			throw new TrainingProgramNotFoundException(e.getMessage());
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
