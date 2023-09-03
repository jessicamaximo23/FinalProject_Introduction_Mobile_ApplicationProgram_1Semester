package ClassLucas;

import java.util.Scanner;

public class Teste3 {

	public static void main(String[] args) {		
		Scanner kb = new Scanner(System.in);
		
		//size of array
		System.out.println("Which size of array? ");

		int N = kb.nextInt();
		int[] myarray = new int[N];
		int sum = 0;

		//elements of array
		for (int k = 0; k < myarray.length; k++) {
			System.out.print("Typing the number " + (k + 1) );
			
			myarray[k] = kb.nextInt();
			
		}
		//sum of the array
		for (int i = 0; i < myarray.length; i++) {
			
			
			// put the condition
			if (myarray[i] % 2 == 0 && myarray[i] % 3 != 0) {
				
				sum += myarray[i];
			}
		}
		System.out.print("The sum is " + sum);
	}
}
