import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

int randNum = -1;
String userName;

    public String getUserName() {
        return userName;
    }
    public int getRandNum() {
        return randNum;
    }

    public void setUserName(String name) {
        userName = name;
    }

    public void setRandNum(int num) {
        randNum = num;
    }

    public void main(String[] args) {
        //Initialize variables
        Random rand = new Random();
        randNum = rand.nextInt(20) + 1;
        int tries = 1;
        boolean playAgain;
        userName = "";
        Scanner userInput = new Scanner(System.in);

        System.out.println("Hello! What is your name?");
        try {

            userName = userInput.nextLine();

        } catch (Exception e) {
            System.out.println("Sorry, only people with names are allowed to play. Goodbye!");
            System.exit(0);
        }

        //start game
        System.out .println("Well, " + userName + " I am thinking of a number between 1 and 20.");
        System.out.println("Take a guess.");
        while(tries <= 6) {
            //loop vars
            String guess;
            int numGuess = -1;
            boolean isNum = true;

            //catcher if guess is a number
            try {
                guess = userInput.nextLine();
                numGuess = Integer.parseInt(guess);
            }
            catch(Exception e) {
                System.out.println("Really? I'm still counting that as a try.");
                isNum = false;
                tries++;
            }


            //Guessed Number
            if (numGuess==randNum) {

                System.out.println("Good job, " + userName + "! You guessed my number in " + tries + " guesses!");
                System.out.println("Would you like to play again? (y or n)");
                String play = "";
                boolean ans = true;
                //quits if no
                while(ans) {
                    try {
                        play = userInput.nextLine();
                        if (play.equals("y") || play.equals("n")) {
                            ans = false;
                        }
                    }
                    catch (Exception e) {
                        System.out.println("Let me repeat myself.");
                        System.out.println("Would you like to play again? (y or n)");
                    }

                }
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
            } else if(numGuess < randNum && isNum) {
                System.out.println("Your guess is too low.");
                System.out.println("Take a guess.");
                tries++;

                //too high
            } else if(isNum) {
                System.out.println("Your guess is too high");
                System.out.println("Take a guess");
                tries++;
            }
        }

        //if unable to guess
        System.out.println("Well, you didn't guess within six tries.");
        System.out.println("Better luck next time!");
    }

}