//package genspark.assignments.section1;

import java.util.Random;
import java.util.Scanner;

public class DragonCave {


    public static void main(String[] args) {
        Random rand = new Random();

        int evilDragon = rand.nextInt(2);

        System.out.println("You are in a land full of dragons. In front of you,");
        System.out.println("you see two caves. In one cave, the dragon is friendly");
        System.out.println("and will share his treasure with you. The other dragon");
        System.out.println("is greedy and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? (1 or 2)");

        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();
        int x = Integer.parseInt(input);

        if(x-1 == evilDragon) {
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("Gobbles you down in one bite!");
        } else {
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("Welcomes you into his cave and offers to share his treasure!");
        }
    }


}
