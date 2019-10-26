package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.bean.Faculty;
import com.cg.exception.FacultyDoesNotExist;

public class FacultyDaoImpl implements FacultyDao {

	@Override
	public int addFacultySkill(Faculty faculty) throws FacultyDoesNotExist {
		
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(fetchFacultyIdQuery);
			stmt.setInt(1, faculty.getFacultyId());
			ResultSet result = stmt.executeQuery();
			
			PreparedStatement stmt2 = conn.prepareStatement(fetchPreviousSkillsetQuery);
			stmt2.setInt(1, faculty.getFacultyId());
			ResultSet rs = stmt2.executeQuery();
			
			if(!result.next()) {
				System.out.println("no fetch query result");
				throw new FacultyDoesNotExist("Faculty id does not exist..");
			} else if(!rs.next()){
				PreparedStatement stmt1 = conn.prepareStatement(saveFacultySkillsetQuery);
				stmt1.setInt(1, faculty.getFacultyId());
				stmt1.setString(2, faculty.getSkillSet());
				stmt1.executeUpdate();
			} else {
					PreparedStatement stmt3 = conn.prepareStatement(updateFacultySkillsetQuery);
					stmt3.setInt(2, faculty.getFacultyId());
					
					String newSkillset = null, delimiter = " , ";
					String previousSkillset = rs.getString(2);
					System.out.println("previous skillset: " + previousSkillset);
					previousSkillset = previousSkillset.concat(delimiter);
					newSkillset = previousSkillset.concat(faculty.getSkillSet());
					stmt3.setString(1, newSkillset);
					stmt3.executeUpdate();
					}
				return result.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyDoesNotExist(e.getMessage());
		} finally {
			if(conn != null)
			try {
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
