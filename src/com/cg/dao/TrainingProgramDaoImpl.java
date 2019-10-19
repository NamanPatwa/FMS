package com.cg.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cg.bean.TrainingProgram;

public class TrainingProgramDaoImpl implements TrainingProgramDao {

	@Override
	public int addTraining(TrainingProgram training) {
		Connection conn = null;
		
		conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement(addtraining);
		stmt.setInt(1, training.getCourseCode());
		stmt.setInt(2, training.getFacultyCode());
		stmt.setDate(3, (Date) training.getStartDate());
		stmt.setDate(4, (Date) training.getEndDate());
		
		stmt.executeUpdate();
		ResultSet rs = conn.createStatement().executeQuery(findtraining);
		
		
		
		return 0;
	}

	@Override
	public TrainingProgram fetchTraining(int trainingCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTraining(int trainingCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int updateTraining(TrainingProgram training) {
		// TODO Auto-generated method stub
		return 0;
	}

}
