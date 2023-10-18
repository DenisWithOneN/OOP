package dao.pojo;

public class Earplugs {
	
	private int id;
	private String brand;
	private double decibelCancelling;
	private String color;
	
	
	
	public Earplugs() {

	}



	public Earplugs(int id, String brand, double decibelCancelling, String color) {
		this.id = id;
		this.brand = brand;
		this.decibelCancelling = decibelCancelling;
		this.color = color;
	}



	public Earplugs(String brand, double decibelCancelling, String color) {
		this.brand = brand;
		this.decibelCancelling = decibelCancelling;
		this.color = color;
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



	public double getDecibelCancelling() {
		return decibelCancelling;
	}



	public void setDecibelCancelling(double decibelCancelling) {
		this.decibelCancelling = decibelCancelling;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
	
	

}
