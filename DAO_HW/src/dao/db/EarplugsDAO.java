package dao.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.helpers.DBHelper;
import dao.pojo.Earplugs;

public class EarplugsDAO {
	
	
	public static ArrayList<Earplugs> getAll() throws SQLException {
		ArrayList<Earplugs> result = new ArrayList<Earplugs>();
		
		Connection con = DBHelper.getConnection();
		Statement statement = con.createStatement();
		String query = "select * from earplugs";
		ResultSet rs = statement.executeQuery(query);
		while(rs.next()) {
			Earplugs e1 = new Earplugs();
			e1.setId(rs.getInt("id"));
			e1.setBrand(rs.getString("brand"));
			e1.setDecibelCancelling(rs.getDouble("decibel_cancelling"));
			e1.setColor(rs.getString("color"));
			result.add(e1);
		
			
			}
		return result;
	}
	
	public static void  create(Earplugs e1) throws SQLException {
		Connection con = DBHelper.getConnection();
		String createQuery = "insert into earplugs (brand, decibel_cancelling, color) values (?, ?, ?)";
		PreparedStatement createStmt = con.prepareStatement(createQuery);
		createStmt.setString(1, e1.getBrand());
		createStmt.setDouble(2, e1.getDecibelCancelling());
		createStmt.setString(3, e1.getColor());
		createStmt.executeUpdate();
		System.out.println("S-a insercat cu succes perechea de earplugs " + e1.getBrand());
	}
	
	public static Earplugs getById(int id) throws SQLException {
		Earplugs result = null;
		Connection con = DBHelper.getConnection();
		
		String query = "select * from earplugs where id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			result = new Earplugs();
			result.setId(rs.getInt("id"));
			result.setBrand(rs.getString("brand"));
			result.setDecibelCancelling(rs.getDouble("decibel_cancelling"));
			result.setColor(rs.getString("color"));
			
		}
		return result;
	}

	public static String delete(String brand) throws SQLException {
		Connection con = DBHelper.getConnection();
		String deleteQuery = "delete from earplugs where brand = ?";
		PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
		deleteStmt.setString(1, brand);
		int dr = deleteStmt.executeUpdate();
		
		return dr == 0 ? "Perechea de earplugs a fost stearsa" : "Perechea de earplugs nu a fost stearsa";
	}
	
	
	public static boolean update(Earplugs e1) throws SQLException {
		
		Connection con = DBHelper.getConnection();
		String updateQuery = "update earplugs set brand = ?, decibel_cancelling = ?, color = ? where id = ?";
		PreparedStatement updateStmt = con.prepareStatement(updateQuery);
		updateStmt.setString(1, e1.getBrand());
		updateStmt.setDouble(2, e1.getDecibelCancelling());
		updateStmt.setString(3, e1.getColor());
		
		int affectedRows = updateStmt.executeUpdate();
		
		return affectedRows == 0 ? true : false;
	}
	
}
