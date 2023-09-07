package Project;
import java.util.Scanner;


public class ComputerStore {
    private static final String PASSWORD = "password";
    private static final int MAX_TRIES = 3;

    private static Computer[] inventory = new Computer[10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            displayMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Option 1
                    break;
                case 2:
                    // Option 2 - Update computer
                    updateComputer(scanner);
                    break;
                case 3:
                    // Option 3
                    break;
                case 4:
                    // Option 4
                    break;
                case 5:
                    // Option 5 - Exit program
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 5);
    }
    
    private static void displayMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Add new computer");
        System.out.println("2. Update computer");
        System.out.println("3. Delete computer");
        System.out.println("4. Display all computers");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private static void updateComputer(Scanner scanner) {
        System.out.print("Enter password: ");
        String password = scanner.next();
        
        if (checkPassword(password)) {
            int tries = 0;
            int computerNumber;
            
            do {
                System.out.print("Enter computer number: ");
                computerNumber = scanner.nextInt();
                
                if (computerNumber >= 0 && computerNumber < inventory.length && inventory[computerNumber] != null) {
                    displayComputerInfo(computerNumber);
                    updateComputerAttribute(scanner, computerNumber);
                    break;
                } else {
                    System.out.println("Invalid computer number. Do you want to enter another computer? (Y/N)");
                    String choice = scanner.next();
                    if (!choice.equalsIgnoreCase("Y")) {
                        break;
                    }
                }
                
                tries++;
            } while (tries < MAX_TRIES);
            
            if (tries >= MAX_TRIES) {
                System.out.println("Max tries exceeded. Returning to main menu...");
            }
        } else {
            System.out.println("Invalid password. Returning to main menu...");
        }
    }
    
    private static boolean checkPassword(String password) {
        return password.equals(PASSWORD);
    }
    
    private static void displayComputerInfo(int computerNumber) {
        Computer computer = inventory[computerNumber];
        
        System.out.println("Computer #" + computerNumber);
        System.out.println("Brand: " + computer.getBrand());
        System.out.println("Model: " + computer.getModel());
        System.out.println("SN: " + computer.getSerialNumber());
        System.out.println("Price: $" + computer.getPrice());
    }
    
    private static void updateComputerAttribute(Scanner scanner, int computerNumber) {
        Computer computer = inventory[computerNumber];
        
        int choice = 0;
        
        do {
            displayAttributeMenu();
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter new brand: ");
                    String brand = scanner.next();
                    computer.setBrand(brand);
                    break;
                case 2:
                    System.out.print("Enter new model: ");
                    String model = scanner.next();
                    computer.setModel(model);
                    break;
                case 3:
                    System.out.print("Enter new serial number: ");
                    String serialNumber = scanner.next();
                    computer.setSerialNumber(serialNumber);
                    break;
                case 4:
                    System.out.print("Enter new price: ");
                    double price = scanner.nextDouble();
                    computer.setPrice(price);
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
            if (choice != 5) {
                System.out.println("Computer #" + computerNumber + " updated:");
                displayComputerInfo(computerNumber);
            }
        } while (choice != 5);
    }
    
    private static void displayAttributeMenu() {
        System.out.println("Update Computer Attribute");
        System.out.println("1. Update brand");
        System.out.println("2. Update model");
        System.out.println("3. Update serial number");
        System.out.println("4. Update price");
        System.out.println("5. Return to main menu");
        System.out.print("Enter your choice: ");
    }
}

class Computer {
    private String brand;
    private String model;
    private String serialNumber;
    private double price;

    public Computer(String brand, String) }
}
}