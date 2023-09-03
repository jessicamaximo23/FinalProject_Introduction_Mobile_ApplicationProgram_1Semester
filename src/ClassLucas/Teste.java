package ClassLucas;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		System.out.println("How many rows you want? ");

		int rows = kb.nextInt();

		for (int i = 1; i <= rows; i++) {
			for (int j = rows; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}

		
	}
}
