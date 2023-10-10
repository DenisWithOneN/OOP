package com.crud.events;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainEvents {

	public static void main(String[] args) {
		//CRUD
		// create, read, update, delete
		
		// 1. url, user, password
		
		String caleURL = "jdbc:mysql://localhost:3306/crud_example";
		String user = "root";
		String pass = "";
		
		try {
		System.out.println("Connecting to db...");
		Connection con = DriverManager.getConnection(caleURL, user, pass);
		System.out.println("Connection done!");
		
		//create event
		String name = "Unchain";
		String presenter = "Calin Donca";
		Date date = new Date(System.currentTimeMillis());
		
		//Query
		String insertEventQuery = "insert into events (event_name, presenter, registration_due) values ('"+name +"','"+presenter+"','"+date+"')";
		
				//executeQuery
				//executeUpdate
		Statement stmt = con.createStatement();
		stmt.executeUpdate(insertEventQuery);
		System.out.println("Inserted event");
		
		//Delete
		
			String deleteQuery = "delete from events where id=2";
			Statement stmtDel = con.createStatement();
			stmtDel.executeUpdate(deleteQuery);
			
			//Read
			String readQuery = "";
			Statement stmtRead = con.createStatement();
			stmtRead.executeQuery(readQuery);
			
			//Update
			String updateQuery = "update events set event_name = 'TED Talk' where id = 3";
			Statement stmtUpdate = con.createStatement();
			stmtUpdate.executeUpdate(updateQuery);
			
		
		con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("finish");

	}
	

}
