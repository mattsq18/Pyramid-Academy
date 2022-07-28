//package genspark.assignments.section2;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        //Initialize variables
        Random rand = new Random();
        int randNum = rand.nextInt(20) + 1;
        int tries = 1;
        boolean playAgain;
        System.out.println("Hello! What is your name?");
        Scanner userInput = new Scanner(System.in);
        String userName = userInput.nextLine();

        //start game
        System.out .println("Well, " + userName + " I am thinking of a number between 1 and 20.");
        System.out.println("Take a guess.");
        while(tries <= 6) {

            String guess = userInput.nextLine();
            int numGuess = Integer.parseInt(guess);

            //Guessed Number
            if (numGuess==randNum) {
                System.out.println("Good job, " + userName + "! You guessed my number in " + tries + " guesses!");
                System.out.println("Would you like to play again? (y or n)");

                //quits if no
                String play = userInput.nextLine();
                playAgain = !play.equals("n");
                if(!playAgain) {
                    System.exit(0);
                }
                tries = 1;
                Random random = new Random();
                randNum = random.nextInt(20) + 1;
                System.out .println("Well, " + userName + " I am thinking of a number between 1 and 20.");
                System.out.println("Take a guess.");

            //too low
            } else if(numGuess < randNum) {
                System.out.println("Your guess is too low.");
                System.out.println("Take a guess.");
                tries++;

            //too high
            } else {
                System.out.println("Your guess is too high");
                System.out.println("Take a guess");
                tries++;
            }
        }
    }

}
