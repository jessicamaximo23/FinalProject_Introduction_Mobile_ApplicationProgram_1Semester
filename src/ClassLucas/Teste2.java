package ClassLucas;

import java.util.Scanner;

public class Teste2 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		
		//Quantity of the marks
		System.out.println("How many marks you enter? ");

		int Marks = kb.nextInt();
		double[] marks = new double[Marks];
		int sum = 0;
    
		//the elements of the array (mark)	
		for (int i = 0; i < Marks; i++) {
			System.out.print("Enter mark " + (i + 1));
			marks[i] = kb.nextDouble();
		}
		//again the elements of the marks
		for (int i = 0; i < Marks; i++) {
			System.out.println("The marks you entered are: " + marks[i]);
		}
		
		//calculator the sum
		for (int i = 0; i < Marks; i++) {
			sum += marks[i];
		}
		//calculator the average
		double average =  sum / Marks;
		System.out.println("The average mark is: " + average);

		kb.close();
	}
}