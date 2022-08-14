import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    //Word to guess
    private String hiddenWord = "cat";
    //hidden word but in a char array
    private char[] hiddenArray; //= {'_', '_', '_'};
    //Errors allowed
    public static final int ERRORS = 6;
    //Errors committed by player
    private int numErrors;
    //letters already entered
    private ArrayList<String> letters = new ArrayList<>();


    public int getNumErrors() {
        return numErrors;
    }

    public char[] getHiddenArray() {
        return hiddenArray;
    }

    public ArrayList<String> getLetters() {
        return letters;
    }

    //Starting a new game initialize necessary variables
    public void startGame() {
        numErrors = 0;
        letters.clear();
        hiddenArray = new char[hiddenWord.length()];
        //fills a blank _ for each char in the hidden word
        Arrays.fill(hiddenArray, '_');

    }

    //checks to see if the word has been completely guessed
    public boolean wordFound() {
        return hiddenWord.contentEquals(new String(hiddenArray));
    }

    //Sees if the letter guessed is correct, incorrect, or already guessed by the player
    public void guess(String c) {
        if(!letters.contains(c)) {
            //correct guess
            if(hiddenWord.contains(c)) {
                int i = hiddenWord.indexOf(c);

                while(i>=0) {
                    hiddenArray[i] = c.charAt(0);
                    i = hiddenWord.indexOf(c, i+1);
                }
            //Incorrect guess
            } else {
                numErrors++;
            }
        } else {
            System.out.println("Whoops! You've entered that already.");
        }

        //adds guess to array of guesses
        letters.add(c);

    }

    //Returns string of current state of the word to guess
    private String arrayContent() {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < hiddenArray.length; i++) {
            builder.append(hiddenArray[i]);
            //adds space between chars
            if(i < hiddenArray.length - 1) {
                builder.append(" ");
            }

        }

        return builder.toString();


    }

    public String updateDisplay(int errorNo) {
        switch(errorNo) {
            case 0:
                return " +---+\n     |\n     |\n     |\n    ===";
            case 1:
                return " +---+\n O   |\n     |\n     |\n    ===";
            case 2:
                return " +---+\n O   |\n |   |\n     |\n    ===";
            case 3:
                return " +---+\n O   |\n |   |\n/    |\n    ===";
            case 4:
                return " +---+\n O   |\n |   |\n/ \\  |\n    ===";
            case 5:
                return " +---+\n O   |\n-|   |\n/ \\  |\n    ===";
            case 6:
                return " +---+\n O   |\n-|-  |\n/ \\  |\n    ===";
        }
        return "";
    }

    //Main game method to play the game
    public void playGame(){
        System.out.println("H A N G M A N");
        try(Scanner input = new Scanner(System.in)) {
            while(numErrors < ERRORS) {
                System.out.println(updateDisplay(numErrors));
                System.out.println("Missed Letters: " + letters);
                System.out.println("\n" + arrayContent());
                System.out.println("\nGuess a letter:");
                String str = input.next();

                //in case of input larger than one letter
                if(str.length() > 1) {
                    str = str.substring(0,1);
                }
                //guess letter
                guess(str);


                if(wordFound()) {
                    numErrors = 0;
                    break;
                } else {
                    System.out.println("\n tries remaining: " + (ERRORS - numErrors));
                }
            }
            if(numErrors >= ERRORS) {
                System.out.println("You've lost :(");
            } else {
                System.out.println("You won!");
            }
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = "y";
       //while(str.equals( "y" )) {
            Hangman hangman = new Hangman();
            hangman.startGame();
            hangman.playGame();

        //}
    }
}
