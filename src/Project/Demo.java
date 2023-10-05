package Project;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {

		// Computer c1 = new Computer("apple", "Mac pro", 3000);
		// c1.displayComputer(c1);

		// Computer c2 = new Computer("apple", "Mac pro", 3000);
		// c1.displayComputer(c2);
		// System.out.println(c1.equal(c2));

		// --------------------------------------------------
		// Here are the part B of the program java
		// We need tracking computers, add new computers or make updates.
		// References: Java, Java, Java Object-Oriented Problem Solving Third Edition R. Morelli and R. Walde
		// Trinity College Hartford, CT June 25, 2017 
		// --------------------------------------------------

		// Display a Welcome message
		System.out.println("Welcome to this program, here we can tracking the computer that you want ");
		System.out.println("-------------------------------------------------------------------------");
		Scanner kb = new Scanner(System.in);

		// Initialize the variables
		int maxComputers = 0;
		// initialize the variable main menu
		int choiceMenu;
		// initialize the variable for add new computers
		int addNewComputers = 0;
		// initialize update computers
		int updateComputersNumber = 0;
		// initialize serial number
		long serialNumberCounter = 0;

		do {
			// owner put the number maximum of computers (Size or maxComputers)
			System.out.println("Whats the maximum numbers of computers that your store can contain? ");
			maxComputers = kb.nextInt();

			// test only with positives numbers
			if (maxComputers > 0) {
			} else {
				System.out.println("Invalid, try again. The number should be positive");
			}
			// continue asking if the number is negative
		} while (maxComputers <= 0);

		// Create a empty array (inventory)
		// Tracking the object computer - previously created
		Computer inventory[] = new Computer[maxComputers];
		// count
		int computerCounter = 0;
		long serialNumber = 0;
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

			// user choose a option between 1 and 5
			choiceMenu = kb.nextInt();

			// if the user put number wrong in the MENU 1
			if (choiceMenu > 5 || choiceMenu <= 0) {
				System.out.println("This number is invalid.Try again");
				System.out.println();
			}
			// Each main menu
			switch (choiceMenu) {

			case 1:
				System.out.println("1.Put your password: ");
				// if the correct password is check put how many computers do want to add
				if (checkPassword(kb)) {
					System.out.println();

					do {
						System.out.println("How many computers do want to add?");
						addNewComputers = kb.nextInt();

						// number can't be negative or more the inventory.length
						if (addNewComputers > inventory.length - computerCounter || addNewComputers <= 0) {
							System.out.println(
									"Please choose other number. This number exceeds tha maximum capacity or is less than 0");
						}
					}
					// while for continue to How many computers do want to add?
					while (addNewComputers > inventory.length - computerCounter || addNewComputers <= 0);

					// check if has enough space in the computer store
					// if the new computers are more than capacity inventory
					if (computerCounter + addNewComputers <= inventory.length
							&& serialNumberCounter + addNewComputers <= inventory.length) {

						// add new computers to the inventory
						// put the quantity of the computers
						for (int i = 0; i < addNewComputers; i++) {

							Computer c = new Computer();
							computerCounter++;
							serialNumberCounter++;

							System.out.println("Computer #:" + computerCounter);

							System.out.print("Brand: ");
							String brand = kb.next();
							c.setBrand(brand);

							// initialize the price
							double price = 0;
							do {
								System.out.print("Price: ");
								price = kb.nextDouble();
								c.setPrice(price);

								// testing for price be only positive numbers
								if (price <= 0) {
									System.out.println("Invalid price.Should be a positive value");
								}
							} while (price <= 0);

							System.out.print("Model: ");
							String model = kb.next();
							c.setModel(model);

							System.out.print("Serial number: " + serialNumberCounter);
							System.out.println();

							// A new method with this new computers
							c = new Computer(brand, model, price);

							// Each computer add will enter the inventory
							inventory[computerCounter - 1] = c;
							System.out.println("Computer(s) added sucessfully");
							System.out.println();
						}
					}
				}
				break;

			case 2:
				System.out.println("2. Put your password");

				// if the correct password is check put how many computers do want to update
				if (checkPassword(kb)) {

					do {
						System.out.println("Which computer number do you want update?");
						// variable for update the computers
						updateComputersNumber = kb.nextInt();

						// check if the update number is positive and in the inventory
						// not should more than inventory = maxComputers
						if (updateComputersNumber > computerCounter || updateComputersNumber <= 0) {
							System.out.println("Try Again.You dont have this number in inventory");
							System.out.println();
						}
					} while (updateComputersNumber > computerCounter || updateComputersNumber <= 0);

					// for update the computer we need to find the index, computer already exist
					// The computer number is the index in the array inventory.
					if (updateComputersNumber > 0 || updateComputersNumber < computerCounter) {
						int index = updateComputersNumber - 1;

						Computer c = inventory[index];
						// Each computer add will enter the inventory
						serialNumberCounter++;
						System.out.println("Computer #: ");
						System.out.println("Model: " + c.getModel());
						System.out.println("Brand: " + c.getBrand());
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

							// if the user put the number wrong in the MENU 2
							if (choicemenu2 > 5 || choicemenu2 <= 0) {
								System.out.println("This number is invalid.Try again");
								System.out.println();
							}
							switch (choicemenu2) {

							case 1:
								System.out.print("1. Enter the new Brand:");
								String brand = kb.next();
								c.setBrand(brand);
								break;
							case 2:
								System.out.print("2. Enter the new Model:");
								String model = kb.next();
								c.setModel(model);
								break;
							case 3:
								// Initialize the serial number
								long newSerialNumber = 0;
								do {
									System.out.print("3.Enter the new SN");
									newSerialNumber = kb.nextLong();
									c.setSerialNumber(newSerialNumber);

									if (newSerialNumber <= 0) {
										System.out.print("Invalid SerialNumber");
									}
								} while (newSerialNumber <= 0);

								break;
							case 4:
								// initialize the price
								double price = 0;
								do {
									System.out.print("4. Enter the new Price: ");
									price = kb.nextDouble();
									c.setPrice(price);

									// not accepted negative numbers in the UPDATE
									if (price <= 0) {
										System.out.print("Invalid price.Should be a positive value");
									}
								} while (price <= 0);

								break;
							case 5:
								System.out.println("5.Quit the Main Menu");
								System.out.println();
								break;

							}
							// System.out.println("Computer(s) changed successfully");
							System.out.println();

						} while (choicemenu2 != 5);
					}
				}
				break;

			case 3:

				String newBrand = "";				
				System.out.println("3. Enter a specific brand");
				newBrand = kb.next();

				findComputersBy(newBrand, inventory);
				break;

			case 4:
				double price = 0;
				do {
					System.out.println("4. Enter a specific price: ");
					price = kb.nextDouble();
					// not accepted negative numbers for looking computers with price
					if (price <= 0) {
						System.out.println("Invalid price.Should be a positive value");
					}
				} while (price <= 0);

				findCheaperThan(price, inventory);
				break;
			case 5:
				System.out.println("5.Exit. The program finish");
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
		int computerCounter = 0;
		long serialNumberCounter = 0;
		// scroll through the information about Computer c
		for (Computer c : inventory) {

			// for app not crash I need to put != null for c and for brand
			if (c != null && c.getBrand() != null && c.getBrand().equalsIgnoreCase(brand)) {
				computerCounter++;
				serialNumberCounter++;
				// print all the informations in computer
				System.out.println("All the computers with this brand: ");
				System.out.println(c);
				System.out.println();
			}
		}
		// if not found any computer with this brand show a message
		if (computerCounter == 0) {
			System.out.println("Try Again.Not found this BRAND in inventory");
			System.out.println();
		}
	}
	public static void findCheaperThan(double price, Computer[] inventory) {
		int computerCounter = 0;
		long serialNumberCounter = 0;

		// scroll through the information about Computer c
		for (Computer c : inventory) {
			// print the values less than price that user put
			if (c != null && c.getPrice() != null && c.getPrice() <= price) {
				computerCounter++;
				serialNumberCounter++;

				System.out.println("All the computers with this prices or less: ");
				System.out.println(c);
				System.out.println();
			}
		}
		// if not found any computer with this price show a message
		if (computerCounter == 0) {
			System.out.println("Try Again.Not found this PRICE in inventory");
			System.out.println();
		}
	}
}
