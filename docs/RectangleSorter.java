package Homework02;
import java.util.Scanner;

public class RectangleSorter {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] areas = null;
        int choice;

        System.out.println("Welcome to the Rectangle Sorter!");

        do {
            System.out.println("\nChoose from the following:");
            System.out.println("1. Sort Rectangles by Smallest to Largest");
            System.out.println("2. Sort Rectangles by Largest to Smallest");
            System.out.println("3. Get Maximum Area");
            System.out.println("4. Get Minimum Area");
            System.out.println("5. Get Average Area");
            System.out.println("9. Reenter Rectangle Data");
            System.out.println("0. To Quit");

            choice = getValidInt(input, "Enter your choice: ");

            switch (choice) {
                case 1:
                    if (areas == null) {
                        System.out.println("No rectangle data entered yet!");
                    } else {
                        sortAscending(areas);
                        System.out.println("Areas Smallest to Largest");
                        printArray(areas);
                    }
                    break;
                case 2:
                    if (areas == null) {
                        System.out.println("No rectangle data entered yet!");
                    } else {
                        sortDescending(areas);
                        System.out.println("Areas Largest to Smallest");
                        printArray(areas);
                    }
                    break;
                case 3:
                    if (areas == null) {
                        System.out.println("No rectangle data entered yet!");
                    } else {
                        System.out.println("The Maximum Area is " + getMax(areas));
                    }
                    break;
                case 4:
                    if (areas == null) {
                        System.out.println("No rectangle data entered yet!");
                    } else {
                        System.out.println("The Minimum Area is " + getMin(areas));
                    }
                    break;
                case 5:
                    if (areas == null) {
                        System.out.println("No rectangle data entered yet!");
                    } else {
                        System.out.println("The Average Area is " + getAverage(areas));
                    }
                    break;
                case 9:
                    areas = enterRectangles(input);
                    break;
                case 0:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    // Helper method to get valid integer input
    public static int getValidInt(Scanner input, String message) {
        while (true) {
            System.out.print(message);
            if (input.hasNextInt()) {
                return input.nextInt();
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                input.next();
            }
        }
    }

    // Allow user to enter rectangles and return array of areas
    public static double[] enterRectangles(Scanner input) {
        int size;
        do {
            System.out.print("How many Rectangles are we creating? ");
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                input.next();
            }
            size = input.nextInt();
            if (size <= 0)
                System.out.println("Please enter a positive number.");
        } while (size <= 0);

        double[] areas = new double[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the length for Rectangle " + i);
            double length = getValidDouble(input);
            System.out.println("Enter the width for Rectangle " + i);
            double width = getValidDouble(input);
            areas[i] = length * width;
        }
        return areas;
    }

    // Validate double input
    public static double getValidDouble(Scanner input) {
        while (!input.hasNextDouble()) {
            System.out.println("Invalid number. Try again:");
            input.next();
        }
        return input.nextDouble();
    }

    // Sort ascending using bubble sort
    public static void sortAscending(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Sort descending using bubble sort
    public static void sortDescending(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Print array contents
    public static void printArray(double[] arr) {
        for (double num : arr) {
            System.out.println(num);
        }
    }

    // Get average area
    public static double getAverage(double[] arr) {
        double sum = 0;
        for (double num : arr) {
            sum += num;
        }
        return sum / arr.length;
    }

    // Get minimum area
    public static double getMin(double[] arr) {
        double min = arr[0];
        for (double num : arr) {
            if (num < min)
                min = num;
        }
        return min;
    }

    // Get maximum area
    public static double getMax(double[] arr) {
        double max = arr[0];
        for (double num : arr) {
            if (num > max)
                max = num;
        }
        return max;
    }
}
}
