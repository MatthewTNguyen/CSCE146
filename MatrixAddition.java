package MatrixAddition;

import java.util.Scanner;

public class MatrixAddition {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the matrix adder program!");

        // Get dimensions for first matrix
        System.out.println("\nPlease enter the length and width of the first matrix");
        int rowsA = input.nextInt();
        int colsA = input.nextInt();

        // Create and fill first matrix
        int[][] matrixA = new int[rowsA][colsA];
        fillMatrix(matrixA, input, "first");

        // Get dimensions for second matrix
        System.out.println("\nPlease enter the length and width of the second matrix");
        int rowsB = input.nextInt();
        int colsB = input.nextInt();

        // Check if dimensions match
        if (rowsA != rowsB || colsA != colsB) {
            System.out.println("\nInvalid Dimensions. These cannot be added.");
            return;
        }

        // Create and fill second matrix
        int[][] matrixB = new int[rowsB][colsB];
        fillMatrix(matrixB, input, "second");

        // Add the matrices
        int[][] resultMatrix = addMatrices(matrixA, matrixB);

        // Print results
        System.out.println();
        printMatrix(matrixA);
        System.out.println("+");
        printMatrix(matrixB);
        System.out.println("=");
        printMatrix(resultMatrix);

        input.close();
    }

    /**
     * Prompts the user to enter the values for a matrix.
     */
    public static void fillMatrix(int[][] matrix, Scanner input, String name) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("Enter value at index " + i + " " + j + " for the " + name + " matrix:");
                matrix[i][j] = input.nextInt();
            }
        }
    }

    /**
     * Adds two matrices and returns the resulting matrix.
     */
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int[][] sum = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        return sum;
    }

    /**
     * Prints a matrix to the console in a readable format.
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}