package dao.pojo;

import java.sql.Date;

public class RubiksCube {

	private int id;
	private String brand;
	private double weight;
	private int sides;
	private Date date;


public RubiksCube() {
	
}

public RubiksCube(int id, String brand, double weight, int sides, Date date) {
	super();
	this.id = id;
	this.brand = brand;
	this.weight = weight;
	this.sides = sides;
	this.date = date;
}

public RubiksCube(String brand, double weight, int sides, Date date) {
	this.brand = brand;
	this.weight = weight;
	this.sides = sides;
	this.date = date;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public double getWeight() {
	return weight;
}

public void setWeight(double weight) {
	this.weight = weight;
}

public int getSides() {
	return sides;
}

public void setSides(int sides) {
	this.sides = sides;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}




}



