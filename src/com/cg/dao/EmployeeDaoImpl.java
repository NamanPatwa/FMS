package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.bean.EmployeeMaster;
import com.cg.exception.FacultyDoesNotExist;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public boolean checkFaculty(int employeeid) throws FacultyDoesNotExist {
		Connection conn = null;
		EmployeeMaster employee = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(checkFaculty);
			stmt.setInt(1, employeeid);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
				return true;
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyDoesNotExist("Faculty Not Found");
		} finally {
			try {
				if(conn != null) 
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}