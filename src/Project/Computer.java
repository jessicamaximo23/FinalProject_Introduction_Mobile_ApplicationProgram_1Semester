package Project;

public class Computer {
	// Project Final
	// Jessica Maximo de Souza
	// Written by: Jessica Maximo de Souza and ID: 2391133

	// Declare variables for each topic
	private String brand;
	private String model;
	private Double price;
	private long serialNumber;
	private static int serialNumberCounter = 1000;
	private static int computerCounter = 000;
	
	
	// Create a constructor for brand, model and price
	public Computer(String br, String m, double pr) {
		brand = br;
		model = m;
		price = pr;
		serialNumber = serialNumberCounter;
		serialNumberCounter++;
	}

	public Computer() {
		serialNumber = serialNumberCounter;
		serialNumberCounter++;
	}
	
	//Make getter and setter for Brand, model price and Serial Number
	public String getBrand() {
		return brand;
	}

	public void setBrand(String br) {
		this.brand = br;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String m) {
		this.model = m;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double pr) {
		this.price = pr;
	}

	public long getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(long sn) {
		this.serialNumber = sn;
	}

	public static void displayComputer(Computer c) {
		System.out.println(" The info is : ");
		System.out.println(" The computer brand is : " + c.getBrand());
		System.out.println(" The computer price is : " + c.getPrice());
		System.out.println(" The computer model is : " + c.getModel());
		System.out.println(" The computer serial number is : " + c.getSerialNumber());
		System.out.println("-----------------------------");
	}

	@Override
	public String toString() {
		return "Computer [brand=" + brand + ", model=" + model + ", price=" + price + ", serialNumber=" + serialNumber
				+ "]";
	}

	//
	public static int findNumberOfCreatedComputers() {
		return computerCounter;
	

	}

	public boolean equal(Computer c) {
		if (brand == c.getBrand() && model == c.getModel() && price == c.getPrice()) {
			return true;

		} else {
			return false;
		}
		
		
		
	}
}



