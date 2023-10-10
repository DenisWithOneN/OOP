package com.crud.foods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainFood {

	public static void main(String[] args) {

		String URL = "jdbc:mysql://localhost:3306/crud_example";
		String user = "root";
		String pass ="";
		
		try {
			System.out.println("Connecting to database");
			Connection con = DriverManager.getConnection(URL, user, pass);
			System.out.println("Connection secured");
			
			String foodName = "Croissant";
			int foodPrice = 2;
			int totalCalories = 200;
			
			String insertFood = "insert into food (food_name, food_price, total_calories) values ('"+foodName+"','"+foodPrice+"','"+totalCalories+"')";
			Statement insertFoodStatement = con.createStatement();
			insertFoodStatement.executeUpdate(insertFood);
			System.out.println("Food added");
			
			int deleteFoodID = 2;
			String deleteFoodQuery = "delete from food where id = " + deleteFoodID;
			Statement deleteFoodStatement = con.createStatement();
			deleteFoodStatement.executeUpdate(deleteFoodQuery);
			System.out.println("Food " + deleteFoodID + " was removed");
			
			String readFoodQuery = "select * from food";
			Statement readFoodStatement = con.createStatement();
			readFoodStatement.executeQuery(readFoodQuery);
			
			int updateFoodID = 1;
			String newFood = "Toortitzi";
			String updateFoodQuery = "update food set food_name = '" +newFood+"' where id = " +updateFoodID;
			Statement updateFoodStatement = con.createStatement();
			updateFoodStatement.executeUpdate(updateFoodQuery);
			System.out.println("Food " + updateFoodID + " was updated");
			
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("finished");
	}

}
