package com.crud.groceries;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainGroceries {

	public static void main(String[] args) {

		String URL = "jdbc:mysql://localhost:3306/crud_example";
		String user = "root";
		String pass="";
		
		try {
			System.out.println("Attempting to connect to database");
			Connection con = DriverManager.getConnection(URL, user, pass);
			System.out.println("Connection secured!");
			
			
			//add grocery
			String groceryItem = "Orange";
			String color = "orange";
			Date expiryDate = new Date(System.currentTimeMillis());
			
			//insert query
			String insertGroceryQuery = "insert into groceries (grocery_item, item_color, expiry_date) values ('"+groceryItem+"','"+color+"','"+expiryDate+"')";
			
			Statement cStmt = con.createStatement();
			cStmt.executeUpdate(insertGroceryQuery);
			System.out.println("Grocery item added");
			
			//delete query
			int deleteGroceryID = 2;
			String deleteQuery = "delete from groceries where id = " + deleteGroceryID;
			Statement dStmt = con.createStatement();
			dStmt.executeUpdate(deleteQuery);
			System.out.println("Item " + deleteGroceryID + " has expired, we got it removed");
			
			//read query
			String readQuery = "select * from groceries";
			Statement rStmt = con.createStatement();
			rStmt.executeQuery(readQuery);
			
			//update query
			
			int updateGroceryID = 1;
			String newGrocery = "Fresh Banana";
			String updateQuery = "update groceries set grocery_item = '" + newGrocery + "' where id = " + updateGroceryID;
			Statement uStmt = con.createStatement();
			uStmt.executeUpdate(updateQuery);
			System.out.println("Good job! Your item" + updateGroceryID + "is freshly brought!");
			
			
			
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("the end");
	}

}
