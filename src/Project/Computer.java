package Project;

import java.util.Scanner;

public class Computer {

	// -------------------------------------------------------------------------------------------------------------
	// Project Final
	// Written by: Jessica Maximo de Souza ID: 2391133
	// This part was a part A of a project final for the course Introduction to
	// mobile application programming
	// Which consists of creating a java program that accesses the following
	// information from a computer (brand, model, price and serial number), this
	// program is flexibly.
	// -------------------------------------------------------------------------------------------------------------

	// Declare variables for each topic
	private String brand;
	private String model;
	private Double price;
	private long serialNumber;
	private static int serialNumberCounter = 1;
	private static int computerCounter;

	// Create a computer object
	// Create a constructor for initialized a brand, model and price
	public Computer(String br, String m, double pr) {
		brand = br;
		model = m;
		price = pr;
		serialNumber = serialNumberCounter;
		// count for numbers of computers created
		serialNumberCounter++;
		computerCounter++;
	}

	public Computer() {
		serialNumber = serialNumberCounter;				
	}
	// Make getter and setter for Brand, model price and Serial Number
	public String getBrand() {
		return brand;
	}
	public void setBrand(String br) {
		brand = br;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String m) {
		model = m;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double pr) {
		price = pr;
	}
	public long getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(long sn) {
		serialNumber = sn;
	}
	// print the information of an object
	// make get for brand, price, model and Serial number
	public static void displayComputer(Computer c) {

		System.out.println("The info is : ");
		System.out.println("The computer brand is : " + c.getBrand());
		System.out.println("The computer price is : " + c.getPrice());
		System.out.println("The computer model is : " + c.getModel());
		System.out.println("The computer serial number is : " + c.getSerialNumber());
		System.out.println("-----------------------------");

	}

	@Override
	public String toString() {
		return "Computer #" + " Brand: " + brand + " || model: " + model + " ||" + " Price: " + price
				+ " ||" + "Serial Number: " + serialNumber + "|| ";
	}

	// for know how many computers are created
	// return the number of computers. The numbers are integer (remember)
	public static int findNumberOfCreatedComputers() {
		return computerCounter;
	}

	// Compare two objects
	// The objects are equal if have the same brand, model and price
	public boolean equal(Computer c) {
		if (c == null) {
			return false;
		}
		if (brand == c.getBrand() && model == c.getModel() && price == c.getPrice()) {
			return true;

		} else {
			return false;
		}
	}
}
