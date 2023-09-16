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
	private static int serialNumberCounter = 1000;
	private static int computerCounter = 000;

	// Create a computer object
	// Create a constructor for initialized a brand, model and price
	public Computer(String br, String m, double pr) {
		brand = br;
		model = m;
		price = pr;
		serialNumber = serialNumberCounter;
		// count for numbers of computers created
		serialNumberCounter++;
	}

	public Computer() {
		serialNumber = serialNumberCounter;
		serialNumberCounter++;
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
		return "Computer [brand=" + brand + ", model=" + model + ", price=" + price + ", serialNumber=" + serialNumber
				+ "]";
	}

	// for know how many computers are created
	// return the number of computers. The numbers are integer (remember)
	public static int findNumberOfCreatedComputers() {
		return computerCounter;
	}

	// Compare two objects
	// The objects are equal if have the same brand, model and price
	public boolean equal(Computer c) {
		if (brand == c.getBrand() && model == c.getModel() && price == c.getPrice()) {
			return true;

		} else {
			return false;
		}
	}
	// --------------------------------------------------
	// Here are the part B of the program java
	// We need tracking computers
	// --------------------------------------------------

	public static void main(String[] args) {
		// Display a Welcome message
		System.out.println("Welcome to this program, here we can tracking the computer that you want ");
		System.out.println("-------------------------------------------------------------------------");
		Scanner kb = new Scanner(System.in);

		int maxComputers = 0;
		// initialize the variable main menu
		int choiceMenu;
		// initialize the variable for add new computers
		int addNewComputers = 0;
		// initialize update computers
		int updateComputersNumber = 0;

		while (maxComputers == 0) {
			// owner put the number maximum of computers (Size or maxComputers)
			System.out.println("Whats the maximum numbers of computers that your store can contain? ");
			maxComputers = kb.nextInt();

			// test only with positives numbers
			if (maxComputers < 1) {
				System.out.println("Invalid, try again. The number should be positve");
			}
		}
		// Create a empty array (inventory)
		// Tracking the object computer - previously created
		Computer inventory[] = new Computer[maxComputers];


		// Put do and while for continue show the main menu
		do {
			// Display a main menu
			System.out.println("You are on the Main menu:  ");
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("Option 1: Enter new computers (Password Required)");
			System.out.println("Option 2: Change information of a computer (Password required)");
			System.out.println("Option 3: Display all computers by a specific brand");
			System.out.println("Option 4: Display all computers under a certain a price");
			System.out.println("Option 5: Quit");
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("Please enter your choice > ");

			// initialized a variably menu
			// user choose a option between 1 and 5
			choiceMenu = kb.nextInt();

			// Each main menu
			switch (choiceMenu) {
			case 1:
				System.out.println(" 1.Put your password: ");
				// if the correct password is check put how many computers do want to add
				if (checkPassword(kb)) {
					System.out.println("How many computers do want to add?");
					addNewComputers = kb.nextInt();

					// check if has enough space in the computer store
					// if the new computers are more than capacity computers
					if (addNewComputers > maxComputers) {
						System.out.println("Please choose other number. This number exceeds tha maximum capacity");
					}
				}

				// add new computers to the inventory
				// put the quantity of the computers
				for (int i = 0; i < addNewComputers; i++) {

					// i+1 because need show "computer 1" instead "computer 0"
					System.out.println("Computer #: " + (i + 1));
					System.out.println("Brand : ");
					String brand = kb.next();

					System.out.println("Price : ");
					double price = kb.nextDouble();

					System.out.println("Model : ");
					String model = kb.next();

					System.out.println("Serial number : ");
					long serialNumber = kb.nextLong();

					// a new method with this new computers
					Computer c = new Computer(brand, model, price);

					// each computer add will enter the inventory
					inventory[i] = c;

					// count the computers
					computerCounter++;

					System.out.println("Computer(s) added sucessfully");

				}
				break;

			case 2:
				System.out.println("2. Put your password");

				// if the correct password is check put how many computers do want to update
				if (checkPassword(kb)) {
					System.out.println("Which computer number do you want update?");

					// variable for update the computers
					updateComputersNumber = kb.nextInt();

					// add a computer we need to find the index, because computer already exist
					int index = updateComputersNumber - 1;

					// The computer number is the index in the array inventory.
					if (index < inventory.length) {

						Computer c = inventory[updateComputersNumber];

						System.out.println("Computer #: " + updateComputersNumber);
						System.out.println("Brand: " + c.getBrand());
						System.out.println("Model: " + c.getModel());
						System.out.println("Computer SerialNumber: " + c.getSerialNumber());
						System.out.println("Price: $ " + c.getPrice());
						System.out.println();

						int choicemenu2;

						// display the UPDATE MENU
						do {
							System.out.println("What information would you like to change? Put the number");
							System.out.println("1.New Brand");
							System.out.println("2.New Model");
							System.out.println("3.New SN");
							System.out.println("4.New Price");
							System.out.println("5.Quit the Update Menu");

							// what information would you like to change?
							choicemenu2 = kb.nextInt();

							switch (choicemenu2) {
							case 1:
								System.out.println("1. Enter the new Brand:");
								String brand = kb.next();
								c.getBrand();
								break;
							case 2:
								System.out.println("2. Enter the new Model:");
								String model = kb.next();
								c.getModel();
								break;
							case 3:
								System.out.println("3.Enter the new SN");
								long serialNumber = kb.nextLong();
								c.getSerialNumber();
								break;
							case 4:
								System.out.println("4. Enter the new Price:");
								double price = kb.nextDouble();
								c.getPrice();

								break;
							case 5:
								System.out.println("5.Quit the Main Menu");
								break;

							}
							System.out.println("Computer(s) changed sucessfully");
						}

						while (choicemenu2 != 5);
					}
				}
				break;

			case 3:
				System.out.println("3. Enter a specific brand");
				String newBrand = kb.next();
				
				Computer c1 = new Computer("apple", "Mac pro", 3050);
				Computer c2 = new Computer("samsung", "pro", 600);
				Computer c3 = new Computer("apple", "pro", 3000);
				Computer c4 = new Computer("asus", "x", 1450);

				findComputersBy(newBrand, inventory);
				
				break;
				
			case 4:
				System.out.println("4. Enter a specific price: ");
				Double price = kb.nextDouble();

				findCheaperThan(price, inventory);
				
				break;
				
			case 5:
				System.out.println(" 5 -> exit. The program finish");
				break;
			}
		} while (choiceMenu != 5);
	}

	public static boolean checkPassword(Scanner kb) {
		// user has only 3 tries
		int passwordTries = 0;

		// while the name password for different that "password" continue to prompt
		while (passwordTries < 3) {
			String namePassword = kb.next();
			passwordTries++;

			if (namePassword.equals("password")) {
				return true;
			} else {
				// After the 3rd illegal entry, the main menu in figure 1 is re-displayed again.
				System.out.println("Invalid, try again");
			}
		}
		return false;
	}

	// method for find all computers with a specific brand
	// Computer inside the class Computer
	public static void findComputersBy(String brand, Computer[] inventory) {

		// scroll through the information about Computer c
		for (Computer c : inventory) {
			if (c.getBrand().equalsIgnoreCase(brand)) {
				// print all the informations in computer
				System.out.println("All the computers with this brand: " );
				System.out.println(c);
				System.out.println();
			}
		}
	}

	public static void findCheaperThan(double price, Computer[] inventory) {

		// scroll through the information about Computer c
		for (Computer c : inventory) {
			// print the values less than price that user put
			if (c.getPrice() < price) {

				System.out.println("All the computers with this prices or less: ");
				System.out.println(c);
				System.out.println();

			} else {
				System.out.println("Not found any computer with this PRICE or less.Try again");
			}
		}

	}

}
