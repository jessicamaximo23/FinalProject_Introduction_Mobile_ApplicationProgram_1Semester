package Project;

import java.util.Scanner;

public class Computer1 {
	public static void main(String[] args) {

		// Display a Welcome message
		System.out.println("Welcome to this program ");
		System.out.println("------------------------");
		Scanner kb = new Scanner(System.in);

		System.out.println("How many computer do you want do add? ");

		//user choose the size
		int size = kb.nextInt();
		
		int maxComputers = 0;
		//continue ask to the user the quantity
				while (maxComputers < 1) {
			System.out.println("Please give me the size");

			// user choose the quantity of computers
			maxComputers = kb.nextInt();
			if (maxComputers < 1) {
				System.out.println("INVALID");
			}
		}
		int choiceMenu = kb.nextInt();
		
		switch (choiceMenu){
		case 1:
			System.out.println("You choose 1");
		case 2:
			System.out.println("You choose 2");
		case 3:
			System.out.println("You choose 3");
		case 4:
			System.out.println("You choose 4");
		case 5:
			System.out.println("You choose 5");
			break;

		}

		// Create a empty array (inventory)
		Computer inventory[] = new Computer[size];

		do {
			System.out.println("What do you want to do: ");
			System.out.println("Enter new computers (Password Required)");
			System.out.println("Change information of a computer (password required)");
			System.out.println("Display all computers by a specific brand");
			System.out.println("Display all computers under a certain a price");
			System.out.println("Quit");

		} while (true);

	}

}
