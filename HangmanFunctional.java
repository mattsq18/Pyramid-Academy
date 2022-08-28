import io.netty.channel.unix.Errors;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


//No loops other than main while loop
//map filter and reduce
//art read from file
//name and score recorded in a file
//tell user if high score
//no exceptions allowed

public class HangmanFunctional {

    //Word to guess
    private final String hiddenWord = "functional";
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

    //sets up new game
    public void startGame() {
        numErrors = 0;
        letters.clear();
        hiddenArray = new char[hiddenWord.length()];
        //fills a blank _ for each char in the hidden word
        Arrays.fill(hiddenArray, '_');

    }

    //checks to see if the word was guessed
    public boolean wordFound() {
        return hiddenWord.contentEquals(new String(hiddenArray));
    }


    public void writeToFile(String name, int score) throws FileNotFoundException {
        File file = new File("src/main/java/scorecard.txt");
        String stringScore = String.valueOf(score);
        String data = name + " " + stringScore;
        try(FileWriter writer = new FileWriter(file, false)) {
            writer.write(data);
            writer.close();
        } catch(Exception e) {
            System.out.println("Whoops! couldn't find file. Check the path?");
        };


    }

    //reads the
    public int checkHighScore() {
        File file = new File("src/main/java/scorecard.txt");
        String data;
        int highScore;
        try {
            Scanner reader = new Scanner(file);
            data = reader.nextLine();
            highScore = Integer.parseInt(String.valueOf(data.charAt(data.length()-1)));
            return highScore;

        } catch(Exception e) {
            System.out.println("Whoops! couldn't find the high score. Check the path?");
            highScore = 999;
            return  highScore;
        }
    }


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

    //Checks if char is in the word or not
    public void guess(String c) {
        if(!letters.contains(c)) {
            //correct guess
            if(hiddenWord.contains(c)) {
                int i = hiddenWord.indexOf(c);
                //adds guess to array of guesses
                letters.add(c);

                while(i>=0) {
                    hiddenArray[i] = c.charAt(0);
                    i = hiddenWord.indexOf(c, i+1);
                }
                System.out.println("You guessed right!");
                //Incorrect guess
            } else {
                numErrors++;
                System.out.println("Unlucky!");
                //adds guess to array of guesses
                letters.add(c);

            }
        } else {
            System.out.println("Whoops! You've entered that already.");
        }


    }

    public void getDisplay() {
        File file = new File("src/main/java/display.txt");
        try(FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();

            String display = new String(data, StandardCharsets.UTF_8);
            System.out.println(display);
        } catch (Exception e) {
            System.out.println("\nERROR WITH DISPLAYING GAME\n");
        }
    }

    public void updateDisplay(int err) {
        File file = new File("src/main/java/display.txt");
        try(FileWriter writer = new FileWriter(file, false)) {
            switch (err) {
                case 0:
                    writer.write("+---+\n     |\n     |\n     |\n    ===");
                    writer.close();
                    break;

                case 1:
                    writer.write(" +---+\n O   |\n     |\n     |\n    ===");
                    writer.close();
                    break;

                case 2:
                    writer.write(" +---+\n O   |\n |   |\n     |\n    ===");
                    writer.close();
                    break;

                case 3:
                    writer.write(" +---+\n O   |\n |   |\n/    |\n    ===");
                    writer.close();
                    break;

                case 4:
                    writer.write(" +---+\n O   |\n |   |\n/ \\  |\n    ===");
                    writer.close();
                    break;

                case 5:
                    writer.write(" +---+\n O   |\n-|   |\n/ \\  |\n    ===");
                    writer.close();
                    break;

                case 6:
                    writer.write(" +---+\n O   |\n-|-  |\n/ \\  |\n    ===");
                    writer.close();
                    break;
            }

        } catch(Exception e) {
            System.out.println("Whoops! couldn't find file. Check the path?");
        };


    }


    public void playGame(String name) throws FileNotFoundException {
        System.out.println("Hello " + name + "! Welcome to:\n");
        System.out.println("H A N G M A N");
        while(numErrors < ERRORS) {
            Scanner input = new Scanner(System.in);

                updateDisplay(numErrors);
                getDisplay();

                System.out.println("Guessed Letters: " + letters.stream().reduce("", (a,b) -> a + " " + b + " "));
                System.out.println("\n" + arrayContent());
                System.out.println("\nGuess a letter:");

                String str = input.next();
                if(str.length() > 1) {
                    str = str.substring(0,1);
                }
                guess(str);

                if(wordFound()) {
                    if(checkHighScore() < ERRORS-numErrors) {
                        System.out.println("\n Congratulations! You've set a new high score of " + (ERRORS-numErrors) + " tries remaining!\n");
                        writeToFile(name, ERRORS-numErrors);

                    };
                    numErrors = 0;
                    updateDisplay(numErrors);
                    break;
                } else {
                    System.out.println("\n tries remaining: " + (ERRORS - numErrors));
                }

            if(numErrors >= ERRORS) {
                System.out.println("You've lost :(");
            } else {
                System.out.println("You won!");
            }
        }
    }



    public static void main(String[] args) throws IOException {
        HangmanFunctional game = new HangmanFunctional();
        //game.writeToFile("Bob", 1);
        //game.getDisplay();
        game.startGame();
        Scanner name = new Scanner(System.in);
        System.out.println("\n Hello! Please enter your name: \n");
        try {
            String str = name.next();
            game.playGame(str);
        } catch(Exception e) {
            System.out.println("\n If you don't enter a real name, you can't play.\n");
        }

    }
}
