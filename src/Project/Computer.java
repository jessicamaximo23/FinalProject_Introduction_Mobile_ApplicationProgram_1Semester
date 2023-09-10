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

				System.out.println("You choose 1.Put your password: ");
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
					System.out.println("Computer brand is: ");
					String brand = kb.next();

					System.out.println("Computer price is: ");
					double price = kb.nextDouble();

					System.out.println("Computer model is: ");
					String model = kb.next();

					System.out.println("Computer serial number is: ");
					long serialNumber = kb.nextLong();

					System.out.println();
					computerCounter++;

					// nao sei como acrescentar esse pc no programa geral
					// nao mostrar toda vez o main menu aqui
					Computer inventoryaddNew[] = new Computer[addNewComputers];

				}
				break;

			case 2:

				do {
					System.out.println("You choose 2. Put your password");
					// if the correct password is check put how many computers do want to update

					if (checkPassword(kb)) {
						System.out.println("Which computer number do you want update?");

						// variable for update the computers
						updateComputersNumber = kb.nextInt();

						// for to add a computer we need to find the index, because computer already
						// exist
						int index = updateComputersNumber - 1;

						// The computer number is the index in the array inventory.

						if (index > 0 && index >= computerCounter) {

							Computer c = inventory[index];

							// ARRUMAR AQUI TA DANDO NULL NO GET
							// como salvar as in formacoes que digitei?
							// display the current information of that computer in the following format:
							System.out.println("Computer:");
							System.out.println("Brand:" + c.getBrand());
							System.out.println("Computer model: " + c.getModel());
							System.out.println("Computer SN: serial number:" + c.getSerialNumber());
							System.out.println("Computer Price: $" + c.getPrice());
						}
					}
				}

				// while the update computers are greater than max computers and less than
				// zero..continue
				while (updateComputersNumber > maxComputers && updateComputersNumber < 0);

				// what information would you like to change?
				int choicemenu2 = kb.nextInt();

				// Then ask the user which attribute they wish to change by displaying menu.
				switch (choicemenu2) {
				case 1:
					System.out.println("Enter the new Brand:");
					String brand = kb.next();

					break;
				case 2:
					System.out.println("Enter the new Model:");
					String model = kb.next();

					break;
				case 3:
					System.out.println("Enter the new SN");
					long serialNumber = kb.nextLong();

					break;
				case 4:
					System.out.println("Enter the new Price:");
					double price = kb.nextDouble();

					break;
				case 5:
					System.out.println("Quit:");
					break;
				}

				break;

			case 3:
				System.out.println("You choose 3. Display all computers by a specific brand");

				// When option 3 is entered, prompt the user to enter a brand name.
				// You then need to display the information of all computers that have that
				// brand. (Hint: You may use a static method,
				// for instance called findComputersBy , which accepts a string for a brand name
				// then performs the needed search).

				break;
			case 4:
				System.out.println("You choose 4. Display all computers by a specific price");

				break;
			case 5:
				System.out.println("You choose 5 -> exit. The program finish");
				break;
			}
		}
		// while menu was different 5 continue ask
		while (choiceMenu != 5);
	}

	// check if the password is correct
	// I really needed to review and remember that scanner has a object type and
	// that by putting it here my kb.next() no longer showed an error
	public static boolean checkPassword(Scanner kb) {
		// user has only 3 tries
		int passwordTries = 0;

		// I needed to remember the syntax equals, before that I tried only use "=="
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
}
