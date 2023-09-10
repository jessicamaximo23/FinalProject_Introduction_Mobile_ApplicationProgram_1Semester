package Project;

import java.util.Scanner;

public class Computer1 {
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
		int updateComputers = 0;

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
					System.out.println("Computer #: " + (i +1 ) + "was add to the inventory");
					
					/*System.out.println("Computer brand is: "  );
					String brand = kb.next();	
					
					System.out.println("Computer price is: ");
					double price = kb.nextDouble();		
					
					System.out.println("Computer model is: ");
					String model = kb.next();
					
					System.out.println("Computer serial number is: ");
					long serialNumber = kb.nextLong();
					
					*/System.out.println("-----------------------------");
					computerCounter++;
					

				}

				break;

			case 2:

				do {
					System.out.println("You choose 2. Put your password");
					// if the correct password is check put how many computers do want to add
					if (checkPassword(kb)) {
						System.out.println("Which computer number do you want update?");

						// variable for update the computers
						updateComputers = kb.nextInt();

						// Loop for trough inside the number of computers
						// The computer number is the index in the array inventory.
						for (int i = 0; i < inventory.length; i++) {
							if (updateComputers == 1) {

								// display the current information of that computer in the following format:
								System.out.println("Computer:");
								System.out.println("Brand:");
								System.out.println("Computer model: ");
								System.out.println("Computer SN: serial number:");
								System.out.println("Computer Price: $");
							}
						}
					}
				}
				// while the update computers are greater than max computers and less than
				// zero..continue
				while (updateComputers > maxComputers && updateComputers < 0);

				break;

			case 3:
				System.out.println("You choose 3. Display all computers by a specific brand");

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
