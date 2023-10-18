package dao.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.helpers.DBHelper;
import dao.pojo.RubiksCube;

public class RubiksCubeDAO {
	
	
	public static ArrayList<RubiksCube> getAll() throws SQLException {
		ArrayList<RubiksCube> result = new ArrayList<RubiksCube>();
		
		Connection con = DBHelper.getConnection();
		Statement stmt = con.createStatement();
		String query = "select * from rubikscube";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			RubiksCube r1 = new RubiksCube();
			r1.setId(rs.getInt("id"));
			r1.setBrand(rs.getString("brand"));
			r1.setWeight(rs.getDouble("weight"));
			r1.setSides(rs.getInt("sides"));
			Date date = rs.getDate("manufactured");
			r1.setDate(date);
			result.add(r1);
			}
		return result;
	}
	
	public static void  create(RubiksCube r1) throws SQLException {
		Connection con = DBHelper.getConnection();
		String createQuery = "insert into rubikscube (brand, weight, sides, manufactured) values (?, ?, ?, ?)";
		PreparedStatement createStmt = con.prepareStatement(createQuery);
		createStmt.setString(1, r1.getBrand());
		createStmt.setDouble(2, r1.getWeight());
		createStmt.setInt(3, r1.getSides());
		createStmt.setDate(4, r1.getDate());
		
		createStmt.executeUpdate();
		System.out.println("S-a insercat cu succes cubul " + r1.getBrand());
	}
	
	public static RubiksCube getById(int id) throws SQLException {
		RubiksCube result = null;
		Connection con = DBHelper.getConnection();
		
		String query = "select * from rubikscube where id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			result = new RubiksCube();
			result.setId(rs.getInt("id"));
			result.setBrand(rs.getString("brand"));
			result.setWeight(rs.getDouble("weight"));
			result.setSides(rs.getInt("sides"));
		}
		return result;
	}

	public static String delete(String brand) throws SQLException {
		Connection con = DBHelper.getConnection();
		String deleteQuery = "delete from rubikscube where brand = ?";
		PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
		deleteStmt.setString(1, brand);
		int dr = deleteStmt.executeUpdate();
		
		return dr == 0 ? "Cubul a fost sters" : "cubul nu a fost sters";
	}
	
	
	public static boolean update(RubiksCube r1) throws SQLException {
		
		Connection con = DBHelper.getConnection();
		String updateQuery = "update rubikscube set brand = ?, weight = ?, sides = ?, manufactured = ? where id = ?";
		PreparedStatement updateStmt = con.prepareStatement(updateQuery);
		updateStmt.setString(1, r1.getBrand());
		updateStmt.setDouble(2, r1.getWeight());
		updateStmt.setInt(3, r1.getSides());
		updateStmt.setDate(4, r1.getDate());
		
		int affectedRows = updateStmt.executeUpdate();
		
		return affectedRows == 0 ? true : false;
	}
	
}
