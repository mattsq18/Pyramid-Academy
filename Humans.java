import java.util.ArrayList;

public class Humans {
    private int humanHP; private ArrayList<String> inventory;

    /* CONSTRUCTORS */

    public Humans() {
        this.humanHP = 100;
        this.inventory = new ArrayList<>();
    }
    public Humans(int humanHP) {
        this.humanHP = humanHP;
        this.inventory = new ArrayList<>();
    }

    /* SETTERS AND GETTERS */

    public int getHumanHP() {
        return humanHP;
    }

    public void setHumanHP(int humanHP) {
        this.humanHP = humanHP;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }


    /* CHECK IF HEALTH IS LOW ENOUGH TO SEE IF PLAYER DIED */

    public boolean checkDeath() {
        if(this.humanHP <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /* METHOD TO RETRIEVE AND PRINT INVENTORY CONTENTS */

    public void checkInventory() {
        if(this.inventory.size() <= 1) {
            System.out.println("\nnothing but dust in here. Maybe kill some goblins?\n");
        } else {
            //System.out.println("\nYour current inventory: \n");
            for (String string : inventory) {
                System.out.println("\n" + string);
            }
        }
    }

    public int checkCoinBalance() {
        int counter = 0;
        for (String string : inventory) {
            if(string.equals("Coin")) {
                counter++;
            }
        }
        return counter;
    }

    /* ADD TO INVENTORY METHOD */
    public void addInv(String str) {
        this.inventory.add(str);
    }


    /* THE ATTACK METHOD */

    public void attack(Goblins goblin) {
        /* Checks if player has gun */
        if(inventory.contains("LMG")) {
            goblin.setGoblinHP(-90);
            System.out.println("\nPlayer absolutely rolls the goblin with the LMG, the goblin has died!\n");

        /* Check if strength potion */
        } else if (inventory.contains("Strength Potion")) {
            int randItemNo = (int)Math.floor(Math.random()*(10-5+1)+5);

            /* if dead else */
            if(goblin.getGoblinHP() <=0) {
                goblin.setGoblinHP(-90);

                System.out.println("\n Player has slain the goblin!\n");
            } else {
                goblin.setGoblinHP(goblin.getGoblinHP() - randItemNo);
                System.out.println("\n Player has done " + randItemNo + " amount of damage to the goblin!\n");
            }
        } else {
            int randItemNo = (int)Math.floor(Math.random()*(5-1+1)+1);

            /* if dead else */
            if(goblin.getGoblinHP() <=0) {
                goblin.setGoblinHP(-90);
                System.out.println("\n Player has slain the goblin!\n");
            } else {
                goblin.setGoblinHP(goblin.getGoblinHP() - randItemNo);
                System.out.println("\n Player has done " + randItemNo + " amount of damage to the goblin!\n");
            }
        }
    }


}
