package com.doors;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public ArrayList<Door> getAllDoors() throws SQLException, IOException {
		Connection con = DBHelper.getConnection();
		String query = "select * from doors";
		PreparedStatement prepStmt = con.prepareStatement(query);
		ResultSet res = prepStmt.executeQuery();
		
		ArrayList<Door> doors = new ArrayList<>();
		
		while(res.next()) {
			Door door = new Door(res.getInt("id"), res.getString("material"), res.getDouble("height"), res.getDouble("width"), ((java.sql.Date) res.getObject("installationDate")).toLocalDate());
			doors.add(door);
		}		
		
		DBHelper.closeConnection();
		return doors;		
	}

	
	public void insertDoor(Door door) throws SQLException, IOException {
		Connection con = DBHelper.getConnection();
		String query = "insert into doors (material, height, width, installationDate) values (?, ?, ?, ?)";
		PreparedStatement prepStmt = con.prepareStatement(query);
		
		prepStmt.setString(1, door.getMaterial());
		prepStmt.setDouble(2, door.getHeight());
		prepStmt.setDouble(3, door.getWidth());
		prepStmt.setDate(4, java.sql.Date.valueOf(door.getInstallationDate()));
		prepStmt.executeUpdate();		
	}
}
