package com.doors;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoorDAO {
	
	public Door getById(int id) throws SQLException, IOException{
		Connection con = DBHelper.getConnection();
		String query = "select * from doors where id = ?";
		PreparedStatement prepStmt = con.prepareStatement(query);
		prepStmt.setInt(1, id);
		
		ResultSet resSet = prepStmt.executeQuery();
		while(resSet.next()) {
			Door door = new Door(resSet.getInt("id"),
					resSet.getString("material"),
					resSet.getDouble("height"),
					resSet.getDouble("width"),
					//transforma Date in localDate
					((java.sql.Date) resSet.getObject("installationDate")).toLocalDate());
			
			DBHelper.closeConnection();
			return door;
		}
		
		DBHelper.closeConnection();
		return null;
		
	}
	
public int getNumberOfDoors() throws SQLException {
	Connection con = DBHelper.getConnection();
		String query = "select count(id) as total from doors where id is not null";
		PreparedStatement prepStmt = con.prepareStatement(query);
		
	ResultSet resSet = prepStmt.executeQuery();
	int total = 0;
	
		while(resSet.next()) {
			total = resSet.getInt("total");
	}
		
	DBHelper.closeConnection();
		return total;
	}

}
