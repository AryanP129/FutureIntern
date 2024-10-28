


import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Generate a random number between 1 and 100
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int userGuess = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");

        // Loop until the user guesses the correct number
        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            
            // Get the user input
            userGuess = scanner.nextInt();
            
            // Check if the guess is too high, too low, or correct
            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number.");
            }
        }
        
        // Close the scanner
        scanner.close();
    }
}
