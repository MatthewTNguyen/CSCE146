package Temperature;

import java.util.Scanner;

public class Temperature {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		//Create an array to store 10 temperatures
		double[] temperatures = new double[10];
		double sum = 0.0;

		System.out.println("Welcome to the below average temperature tester program!");

		// Input loop for 10 days of temperatures
		for (int i=0; i < temperatures.length; i++) {
			System.out.print("Please enter the temperature for day " + (i + 1) + ": ");
			temperatures[i] = input.nextDouble(); // store user input in array
			sum += temperatures[i]; // add to sum for average calculation
		}
		// Calculate average
		double average = sum / temperatures.length;

		// Display the average
		System.out.printf("%nThe average temperature was %.1f%n", average);

		// Display temperatures strictly below average
		System.out.println("The days that were below average were:");
		boolean foundBelow = false; // flag to check if any below-average values exist
		for (int i = 0; i < temperatures.length; i++) {
			if (temperatures[i] < average) {
				System.out.printf("Day %d with %.1f%n", (i + 1), temperatures[i]);
				foundBelow = true;
				// If no temperatures are below average, print nothing extra (per requirements)
				if (!foundBelow) {
					System.out.println("(No days were below average.)");
				}

				input.close(); // close the scanner
			}
		}
	}
}