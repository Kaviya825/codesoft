import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        boolean play = true;

        while (play) {
            int numb = random.nextInt(100) + 1;
            int attempts = 0;
            int max = 10;
            boolean guess = false;

            System.out.println("Guess the number between 1 and 100. You have " + max + " attempts.");

            while (attempts < max && !guess) {
                System.out.print("Enter your guess: ");
                int userGuess = scan.nextInt();
                attempts++;

                if (userGuess < numb) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numb) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guess = true;
                }
            }

            if (!guess) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + numb);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String userResponse = scan.next();
            play = userResponse.equalsIgnoreCase("yes");
        }

        scan.close();
        System.out.println("Thank you for playing!");
    }
}
