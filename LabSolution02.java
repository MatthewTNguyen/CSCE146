package Triangle;

import java.util.Scanner;

//Start Lab
public class LabSolution02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Triangle Maker!");
		System.out.print("Enter the size of the triangle: ");

		int size = input.nextInt();

		if (size <= 0) {
			System.out.println("Error: The number must be postive and greater than zero.");

		}else {	

			// prints amount of rows we need
			//printing amount of stars in a single line

			for(int i=1; i<=size; i++) {

				//printing amount of stars in a single line	
				for(int j=1; j<=i; j++) {
					System.out.print("*");
				}
				System.out.println();

			}

		}

		//reverse of original
		// prints amount of rows we need
		// - 1 because we dont want ot start at the largest amount of stars when printing a triangle
		for(int i=size - 1; i>=1; i--) {
			//printing amount of stars in a single line				
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();

		}


	}
}
