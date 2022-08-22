

public class Goblins {
    private int goblinHP; int[] goblinCoords;

    /* CONSTRUCTORS */

    public Goblins() {
        goblinHP = 15;
        this.goblinCoords = new int[2];
    }

    public Goblins(int goblinHP) {
        this.goblinHP = goblinHP;
        this.goblinCoords = new int[2];
    }

    /* SETTERS AND GETTERS */
    public int getGoblinHP() {
        return goblinHP;
    }

    public void setGoblinHP(int goblinHP) {
        this.goblinHP = goblinHP;
    }

    public int[] getGoblinCoords() {
        return goblinCoords;
    }

    public void setGoblinCoords(int[] goblinCoords) {
        this.goblinCoords = goblinCoords;
    }

    /* CHECK IF HEALTH IS LOW ENOUGH TO SEE IF GOBLIN DIED */

    public boolean checkDeath() {
        if(this.goblinHP <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void attack(Humans human) {
        int randItemNo = (int)Math.floor(Math.random()*(5-1+1)+1);



        if(human.checkDeath()) {
            System.out.println("\nPlayer has been slain by the goblin!\n");
        } else {
            human.setHumanHP(human.getHumanHP() - randItemNo);
            System.out.println("\n Goblin strikes the player for " + randItemNo + " damage!\n");
        }
    }

    /* RANDOM DROP METHOD ON DEATH */

    public String dropItem() {
        int randItemNo = (int)Math.floor(Math.random()*(100-1+1)+1);
        if(randItemNo>=0 && randItemNo<=25) {
            return "Health Potion";
        } else if(randItemNo>25 && randItemNo <=50) {
            return "Strength Potion";
        } else if(randItemNo >51 && randItemNo <98) {
            return "Coin";
        } else {
            return "LMG";
        }
    }


}
