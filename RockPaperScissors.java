
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    
    // Method to get the computer's random choice
    public static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        Random random = new Random();
        int index = random.nextInt(choices.length);
        return choices[index];
    }
    
    // Method to determine the winner
    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (userChoice.equals("scissors") && computerChoice.equals("paper")) ||
                   (userChoice.equals("paper") && computerChoice.equals("rock"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
    
    // Main game method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Rock, Paper, Scissors!");

        while (true) {
            System.out.print("Enter 'rock', 'paper', or 'scissors' (or 'quit' to stop playing): ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("quit")) {
                System.out.println("Thanks for playing!");
                break;
            } else if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            String computerChoice = getComputerChoice();
            System.out.println("Computer chose: " + computerChoice);

            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }

        scanner.close();
    }
}
