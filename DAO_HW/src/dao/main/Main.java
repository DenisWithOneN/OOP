package dao.main;

import java.sql.Date;
import java.sql.SQLException;

import dao.db.EarplugsDAO;
import dao.db.RubiksCubeDAO;
import dao.db.WaterBottleDAO;
import dao.pojo.Earplugs;
import dao.pojo.RubiksCube;
import dao.pojo.WaterBottle;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		Date manufacturedDate = new Date(123, 0, 15);
		RubiksCube r1 = new RubiksCube("YJ", 130, 6, manufacturedDate);
		RubiksCubeDAO.create(r1);
		
		Earplugs e1 = new Earplugs("Travel", 15, "red");
		EarplugsDAO.create(e1);
		
		WaterBottle wb = new WaterBottle("Klean Kanteen", 0.75, "black", true);
		WaterBottleDAO.create(wb);
	}

}
