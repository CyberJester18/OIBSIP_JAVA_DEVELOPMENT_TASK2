import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("=================================");
        System.out.println("  WELCOME TO NUMBER GUESSING GAME ");
        System.out.println("=================================");

        while (playAgain) {

            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    int points = (maxAttempts - attempts + 1) * 10;
                    totalScore += points;

                    System.out.println("Correct! You guessed the number.");
                    System.out.println("Attempts used: " + attempts);
                    System.out.println("Points earned: " + points);
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\n You've used all attempts.");
                System.out.println("The correct number was: " + numberToGuess);
            }

            System.out.println("Your total score: " + totalScore);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String choice = scanner.next().toLowerCase();

            if (!choice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing!");
        System.out.println("Final Score: " + totalScore);
        scanner.close();
    }
}
