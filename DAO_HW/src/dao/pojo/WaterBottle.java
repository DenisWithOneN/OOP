package dao.pojo;

public class WaterBottle {
	
	private int id;
	private String brand;
	private double capacity;
	private String color;
	private boolean leakProof;
	
	
	public WaterBottle() {
	}


	public WaterBottle(int id, String brand, double capacity, String color, boolean leakProof) {
		this.id = id;
		this.brand = brand;
		this.capacity = capacity;
		this.color = color;
		this.leakProof = leakProof;
	}


	public WaterBottle(String brand, double capacity, String color, boolean leakProof) {
		super();
		this.brand = brand;
		this.capacity = capacity;
		this.color = color;
		this.leakProof = leakProof;
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


	public double getCapacity() {
		return capacity;
	}


	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public boolean isLeakProof() {
		return leakProof;
	}


	public void setLeakProof(boolean leakProof) {
		this.leakProof = leakProof;
	}
	
	
	
	
	

}
