package com.cg.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.TrainingProgram;
import com.cg.exception.InvalidCourseException;
import com.cg.exception.TrainingProgramNotFoundException;

public class TrainingProgramDaoImpl implements TrainingProgramDao {

	@Override
	public int addTraining(TrainingProgram training) throws TrainingProgramNotFoundException {
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			System.out.println("before adds");
			PreparedStatement stmt = conn.prepareStatement(addTrainingProgram);
			
			stmt.setInt(1, training.getCourseCode());
			stmt.setInt(2, training.getFacultyCode());
			stmt.setDate(3, (Date) training.getStartDate());
			stmt.setDate(4, (Date) training.getEndDate());
			stmt.executeUpdate();
			System.out.println("mid adds");

			PreparedStatement stmt2 = conn.prepareStatement(fetchTrainingProgramByTrainingCode);
			stmt2.setInt(1, training.getTrainingCode());
			ResultSet rs = stmt2.executeQuery();
			System.out.println("after adds");

			if(rs.next()) 
				return rs.getInt(1);
			else
				return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TrainingProgramNotFoundException("Failure to add new course");
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public List<TrainingProgram> fetchAllTrainingProgram() throws TrainingProgramNotFoundException {
	List<TrainingProgram> programs=new ArrayList<TrainingProgram>();
	Connection conn = null;
	try {
		conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement(fetchAllTrainingProgram);
		
		ResultSet result = stmt.executeQuery();
		while(result.next()) {
			TrainingProgram program = new TrainingProgram();
			program.setTrainingCode(result.getInt(1));
			program.setCourseCode(result.getInt(2));
			program.setFacultyCode(result.getInt(3));
			program.setStartDate(result.getDate(4));
			program.setEndDate(result.getDate(5));
			programs.add(program);
		}
		if(programs.size() == 0)
			throw new TrainingProgramNotFoundException("No Training Programs exists as of now!!");
		return programs;
	} catch (SQLException e) {
		throw new TrainingProgramNotFoundException(e.getMessage());
	} finally {
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	}

	@Override
	public TrainingProgram fetchTrainingProgramByTrainingCode(int code) throws TrainingProgramNotFoundException {
		Connection conn = null;
		TrainingProgram program=null;

		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(fetchTrainingProgramByTrainingCode);
			stmt.setInt(1, code);
			
			ResultSet result = stmt.executeQuery();
			if(result.next()) {
				program = new TrainingProgram();
				program.setTrainingCode(result.getInt(1));
				program.setCourseCode(result.getInt(2));
				program.setFacultyCode(result.getInt(3));
				program.setStartDate(result.getDate(4));
				program.setEndDate(result.getDate(5));
			} else
				throw new TrainingProgramNotFoundException("Training Program does not exist..");
			return program;
		} catch (SQLException e) {
			throw new TrainingProgramNotFoundException(e.getMessage());
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public TrainingProgram updateTrainingProgram(TrainingProgram training) throws TrainingProgramNotFoundException {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt1 = conn.prepareStatement(fetchTrainingProgramByTrainingCode);
			stmt1.setInt(1, training.getTrainingCode());
			ResultSet result = stmt1.executeQuery();

			if(!result.next())
			{
				throw new TrainingProgramNotFoundException("training details can not be updated.. training id not found.");

			}
			else {

				PreparedStatement stmt = conn.prepareStatement(updateTrainingProgram);
				stmt.setInt(1, training.getCourseCode());
				stmt.setInt(2, training.getFacultyCode());
				stmt.setDate(3, (Date) training.getStartDate());
				stmt.setDate(4, (Date) training.getEndDate());
				stmt.setInt(5, training.getTrainingCode());
				stmt.executeUpdate();
				//stmt.execute();

			}
			return training;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TrainingProgramNotFoundException("Failure to update new course");
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public boolean removeTrainingProgram(int code) throws TrainingProgramNotFoundException {
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement( removeTrainingProgram);
			stmt.setInt(1, code);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new TrainingProgramNotFoundException(e.getMessage());
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Date getTrainingDate(int trainingCode) {
		Connection conn = null;
		Date date = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(getTrainingDate);
			stmt.setInt(1, trainingCode);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				date = rs.getDate(1);
				return date;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
