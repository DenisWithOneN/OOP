package com.crud.ads;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainAds {

	public static void main(String[] args) {
		
		String caleURL = "jdbc:mysql://localhost:3306/crud_example";
		String user = "root";
		String pass = "";
		
		try {
		System.out.println("Connecting to database...");
		Connection con = DriverManager.getConnection(caleURL, user, pass);
		System.out.println("Connection successful!");
		
		//create ad
		String title = "Lego Dodge";
		int amount = 5;
		Date date = new Date(System.currentTimeMillis());
		
		//insert query
		String insertAdQuery = "insert into ads (title,  amount, date) values ('"+title+"','"+amount+"','"+date+"')";
		
		Statement createStatement = con.createStatement();
		createStatement.executeUpdate(insertAdQuery);
		System.out.println("new ad inserted");
		
		//delete query
		// index of the item you wish to delete
		int deleteID = 10;
		String deleteQuery = "delete from ads where id = " + deleteID;
		Statement deleteStatement = con.createStatement();
		deleteStatement.executeUpdate(deleteQuery);
		System.out.println("Item "+ deleteID + " was  deleted");
		
		//read query
		String readQuery="select * from ads";
		Statement readStatement = con.createStatement();
		readStatement.executeQuery(readQuery);
		
		//update query
		//index of the item you wish to update
		int updateID = 1;
		String newTitle = "LEGOOOOOO";
		String updateQuery = "update ads set title = '" + newTitle + "' where id = " + updateID;
		Statement updateStatement = con.createStatement();
		updateStatement.executeUpdate(updateQuery);
		System.out.println("your " + updateID + " item was updated");
		
		con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished");
		
		

	}

}
