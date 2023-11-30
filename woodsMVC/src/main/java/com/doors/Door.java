package com.doors;

import java.time.LocalDate;

public class Door {
	
	public Door(int id, String material, double height, double width, LocalDate installationDate) {
		this.id = id;
		this.material = material;
		this.height = height;
		this.width = width;
		this.installationDate = installationDate;
	}
	
	public Door(String material, double height, double width, LocalDate installationDate) {
		this.material = material;
		this.height = height;
		this.width = width;
		this.installationDate = installationDate;
	}
	
	private int id;
	private String material;
	private double height;
	private double width;
	private LocalDate installationDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public LocalDate getInstallationDate() {
		return installationDate;
	}
	public void setInstallationDate(LocalDate installationDate) {
		this.installationDate = installationDate;
	}
	
	

}
