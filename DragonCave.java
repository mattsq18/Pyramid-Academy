import java.util.Random;
import java.util.Scanner;

public class DragonCave {
int evilDragon = 0;
boolean riggedGame = false;

    //setters
    public void setRiggedGame(boolean bool) {
        riggedGame = bool;
    }

    public void setEvilDragon(int dragon) {
        evilDragon = dragon;
    }

    //getters
    public boolean getRiggedGame() {
        return riggedGame;
    }

    public int getEvilDragon() {
        return evilDragon;
    }

    //game
    public String game() {
        Random rand = new Random();
        if (!riggedGame) {
           evilDragon = rand.nextInt(2) + 1;
        }

        int x = 3;

        System.out.println("You are in a land full of dragons. In front of you,");
        System.out.println("you see two caves. In one cave, the dragon is friendly");
        System.out.println("and will share his treasure with you. The other dragon");
        System.out.println("is greedy and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? (1 or 2)");


        while(x>2 || x <1) {
            try {
                Scanner userInput = new Scanner(System.in);
                String input = userInput.nextLine();
                x = Integer.parseInt(input);
                if(x>2 || x <1) {
                    System.out.println("You lose focus for a moment, then remember there are two caves.");
                    System.out.println("Which cave will you go into? (1 or 2)");
                }
            }
            catch(Exception e) {

                return "You suffer a heart attack from the stress of indecisiveness!";


            }

        }

        System.out.println("You approach the cave...");
        System.out.println("It is dark and spooky...");
        System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");

        if(x == evilDragon) {

            return "Gobbles you down in one bite!";

        } else {

            return "Welcomes you into his cave and offers to share his treasure!";

        }

    }

    public static void main() {

    }


}
