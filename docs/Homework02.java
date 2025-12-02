package Homework02;

import java.util.Random;
import java.util.Scanner;

public class Homework02 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Rock Paper Scissors! Best 2 out of 3!");

        boolean playAgain = true;

        while (playAgain) {
            int playerScore = 0;
            int computerScore = 0;
            int roundsPlayed = 0;

            // Play exactly 3 rounds
            while (roundsPlayed < 3) {
                System.out.println("\nEnter \"Rock\", \"Paper\", or \"Scissors\":");
                String playerChoice = input.nextLine().trim().toLowerCase();

                // Randomly choose computer's move
                int compNum = random.nextInt(3); // 0=rock, 1=paper, 2=scissors
                String computerChoice = "";
                if (compNum == 0) computerChoice = "rock";
                else if (compNum == 1) computerChoice = "paper";
                else computerChoice = "scissors";

                // Determine result
                if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
                    System.out.println("Not a valid input! Computer wins this round.");
                    computerScore++;
                } else if (playerChoice.equals(computerChoice)) {
                    System.out.println(capitalize(playerChoice) + " vs " + capitalize(computerChoice) + "! It's a tie!");
                } else if (
                        (playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                        (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                        (playerChoice.equals("scissors") && computerChoice.equals("paper"))
                ) {
                    System.out.println(capitalize(playerChoice) + " vs " + capitalize(computerChoice) + "! Player wins this round!");
                    playerScore++;
                } else {
                    System.out.println(capitalize(playerChoice) + " vs " + capitalize(computerChoice) + "! Computer wins this round!");
                    computerScore++;
                }

                // Show current scores
                System.out.println("Player has won " + playerScore + " times and the computer has won " + computerScore + " times.");
                roundsPlayed++;
            }

            // Determine final winner
            System.out.println();
            if (playerScore > computerScore)
                System.out.println("The Player wins!");
            else if (computerScore > playerScore)
                System.out.println("The Computer wins!");
            else
                System.out.println("It's a tie overall!");

            // Ask for replay
            System.out.println("\nPlay again? \"Yes\" or \"No\"");
            String response = input.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("Goodbye!");
            }
        }

        input.close();
    }

    // ✅ Helper method to capitalize first letter of a word
    public static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
