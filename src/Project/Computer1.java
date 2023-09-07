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

		// owner put the number maximum of computers (Size or maxComputers)	
		System.out.println("Whats the maximum numbers of computers that your store can contain? ");
		int maxComputers = kb.nextInt();

		// Create a empty array (inventory)
		// Tracking the object computer - previously created
		Computer inventory[] = new Computer[maxComputers];

		// colocar dentro do while pra continuar mostrando o main menu
		while (true) {		
		// Display a main menu
		System.out.println("You are on the Main menu:  ");
		System.out.println("Select a option between 1 and 5");
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
		int choiceMenu= kb.nextInt();

		
			// Each option
			switch (choiceMenu) {
			case 1:
				System.out.println("You choose 1.Put your password: ");
				//if the correct password is check put how many computers do want to add
				if (checkPassword(kb)) {
					System.out.println("How many computers do want to add?");
				}
				break;
				
			case 2:
				System.out.println("You choose 2. Put your password");
				//if the correct password is check put how many computers do want to add
				if (checkPassword(kb)) {
					System.out.println("Which computer do you want update?");
				}
				break;
			case 3:
				System.out.println("You choose 3. Display all computers by a specific brand");
				break;
			case 4:
				System.out.println("You choose 4. Display all computers by a spacific price");
				break;
			case 5:
				System.out.println("You choose 5 -> exit. The program finish");
				break;

			}
			// while menu was different 5 continue ask
		while (choiceMenu != 5);
		}
		
	}
	
	// check if the password is correct
	// I really needed to review and remember that scanner has a object type and
	// that by putting it here my kb.next() no longer showed an error
	public static boolean checkPassword(Scanner kb) {
		// user has only 3 tries
		int passwordTries = 3;
		
		// I needed to remember the syntax equals, before that I tried only use "=="
		// while the name password for different that "password" continue to prompt
		while (passwordTries > 0) {
			String namePassword = kb.next();
					
		if (namePassword.equals("password")) {
			return true;

		}else  {
			//TENTAR COLOCAR ISSO APENAS TRES TEANTATIVAS E PRINT O MENU, NAO TO CONSEGUINDO COLOCAR AINDA
			//COLCOAR PRA NAO ACEITAR NUMERO NEGATIVO
			//After the 3rd illegal entry, the main menu in figure 1 is re-displayed again.
			System.out.println("Invalid, try again");
			
		}
		}		
		return false;

	}
	//create a new method for update information
	//put the quantity of the computers

	// print the information of an object
	// make get for brand, price, model and Serial number
		public static void displayComputer(Computer c, Scanner kb) {

		System.out.println("The info is : ");
		System.out.println("Computer brand is : " + c.getBrand());
		System.out.println("Computer price is : " + c.getPrice());
		System.out.println("Computer model is : " + c.getModel());
		System.out.println("Computer serial number is : " + c.getSerialNumber());
		System.out.println("-----------------------------");
		
		//choose the second menu
		int choiceMenu2 = kb.nextInt();
		
	}
			
			
		
}
