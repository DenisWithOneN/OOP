package dao.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; 

import dao.helpers.DBHelper;
import dao.pojo.WaterBottle;

public class WaterBottleDAO {
	
	
	public static ArrayList<WaterBottle> getAll() throws SQLException {
		ArrayList<WaterBottle> result = new ArrayList<WaterBottle>();
		
		Connection con = DBHelper.getConnection();
		Statement statement = con.createStatement();
		String query = "select * from water_bottles";
		ResultSet rs = statement.executeQuery(query);
		while(rs.next()) {
			WaterBottle wb = new WaterBottle();
			wb.setId(rs.getInt("id"));
			wb.setBrand(rs.getString("brand"));
			wb.setCapacity(rs.getDouble("capacity"));
			wb.setColor(rs.getString("color"));
			wb.setLeakProof(rs.getBoolean("leak_proof"));
			result.add(wb);
			}
		return result;
	}
	
	public static void  create(WaterBottle wb) throws SQLException {
		Connection con = DBHelper.getConnection();
		String createQuery = "insert into water_bottles (brand, capacity, color, leak_proof) values (?, ?, ?, ?)";
		PreparedStatement createStmt = con.prepareStatement(createQuery);
		createStmt.setString(1, wb.getBrand());
		createStmt.setDouble(2, wb.getCapacity());
		createStmt.setString(3, wb.getColor());
		createStmt.setBoolean(4, wb.isLeakProof());
		createStmt.executeUpdate();
		System.out.println("S-a insercat cu succes sticla " + wb.getBrand());
	}
	
	public static WaterBottle getById(int id) throws SQLException {
		WaterBottle result = null;
		Connection con = DBHelper.getConnection();
		
		String query = "select * from water_bottles where id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			result = new WaterBottle();
			result.setId(rs.getInt("id"));
			result.setBrand(rs.getString("brand"));
			result.setCapacity(rs.getDouble("capacity"));
			result.setColor(rs.getString("color"));
			result.setLeakProof(rs.getBoolean("leak_proof"));
			
		}
		return result;
	}

	public static String delete(String brand) throws SQLException {
		Connection con = DBHelper.getConnection();
		String deleteQuery = "delete from water_bottles where brand = ?";
		PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
		deleteStmt.setString(1, brand);
		int dr = deleteStmt.executeUpdate();
		
		return dr == 0 ? "Sticla a fost stearsa" : "Sticla nu a fost stearsa";
	}
	
	
	public static boolean update(WaterBottle wb) throws SQLException {
		
		Connection con = DBHelper.getConnection();
		String updateQuery = "update water_bottles set brand = ?, capacity = ?, color = ?, leak_proof = ? where id = ?";
		PreparedStatement updateStmt = con.prepareStatement(updateQuery);
		updateStmt.setString(1, wb.getBrand());
		updateStmt.setDouble(2, wb.getCapacity());
		updateStmt.setString(3, wb.getColor());
		updateStmt.setBoolean(4, wb.isLeakProof());
		
		int affectedRows = updateStmt.executeUpdate();
		
		return affectedRows == 0 ? true : false;
	}
	
}
