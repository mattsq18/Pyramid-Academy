import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LandMap {
    private int size, numGoblins; int[] playerCords; int[] chestCoords; char[][] map; ArrayList<Goblins> goblins;


    /* CONSTRUCTORS */

    public LandMap() {
        this.playerCords = new int[] {0,0};
        this.size = 10;
        this.numGoblins = 5;
        this.map = new char[size][size];
        this.goblins = new ArrayList<Goblins>();
    }

    public LandMap(int size) {
        this.playerCords = new int[] {0,0};
        this.size = size;
        this.numGoblins = this.size/2;
        this.map = new char[size][size];
        this.goblins = new ArrayList<Goblins>();
    }

    public  LandMap(int size, int numGoblins) {
        this.playerCords = new int[] {0,0};
        this.size = size;
        this.numGoblins = numGoblins;
        this.map = new char[size][size];
        this.goblins = new ArrayList<Goblins>();
    }

    /* SETTERS AND GETTERS */

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumGoblins() {
        return numGoblins;
    }

    public void setNumGoblins(int numGoblins) {
        this.numGoblins = numGoblins;
    }

    public int[] getPlayerCords() {
        return playerCords;
    }

    public void setPlayerCords(int[] playerCords) {
        this.playerCords = playerCords;
    }

    /* INITIALIZE THE GOBLINS */

    public void setupGoblins() {
        Goblins goblins1 = new Goblins();
        Goblins goblins2 = new Goblins();
        Goblins goblins3 = new Goblins();
        Goblins goblins4 = new Goblins();
        Goblins goblins5 = new Goblins();

        goblins.add(goblins1);
        goblins.add(goblins2);
        goblins.add(goblins3);
        goblins.add(goblins4);
        goblins.add(goblins5);



        for (Goblins goblin: goblins) {
            //Random spawn for each goblin
            int[] tempCoords = new int[] { (int)Math.floor(Math.random()*(this.size)),(int)Math.floor(Math.random()*(this.size))};
            while(isOccupied(tempCoords)) {
                tempCoords = new int[] { (int)Math.floor(Math.random()*(this.size)) , (int)Math.floor(Math.random()*(this.size))};
            }

            goblin.setGoblinCoords(tempCoords);
            
        }

    }

    /* GOBLIN DEATH CHECKER */
    public boolean checkGoblinsDead() {
        for (Goblins goblin: goblins) {
            if(!goblin.checkDeath()) {
                return false;
            }
        }
        return true;
    }


    /* THE MAP DISPLAYER */
    public void displayMap() {
        //void
        for(int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                map[x][y] = '-';
            }
        }

        //player
        map[playerCords[0]][playerCords[1]] = 'P';

        //goblins
        for(int y = 0; y < size; y++) {
            for(int x = 0; x < size; x++) {
                for (Goblins goblin: goblins) {
                    if(Arrays.equals(goblin.getGoblinCoords(), new int[]{x, y}) && !goblin.checkDeath()) {
                        map[x][y] = 'G';
                    }
                }
            }
        }

        for (int y = 0; y < size; y++) {
            for(int x = 0; x < size; x++) {
                System.out.print(map[x][y] + " ");

            }
            System.out.print("\n");
        }


    }

    /* MOVE PLAYER */

    public void movePlayer(String input) {
        switch (input) {
            case "n":
                if (playerCords[1] <= 0) {
                    System.out.println("\n Invalid Move!\n");
                } else {
                    playerCords[1]--;
                }
                break;
            case "s":
                if (playerCords[1] >= this.size - 1) {
                    System.out.println("\n Invalid Move!\n");
                } else {
                    playerCords[1]++;
                }
                break;
            case "w":
                if (playerCords[0] <= 0) {
                    System.out.println("\n Invalid Move!\n");
                } else {
                    playerCords[0]--;
                }
                break;
            case "e":
                if (playerCords[0] >= this.size - 1) {
                    System.out.println("\n Invalid Move!\n");
                } else {
                    playerCords[0]++;
                }

                break;
            default:
                System.out.println("\n Enter Valid Move!\n");
                break;
        }
    }

    /* CHECK IF SPACE IS OCCUPIED */

    public boolean isOccupied(int[] coords) {
        if(coords == playerCords) {
            return true;
        } else if(coords == chestCoords) {
            return  true;
        } else {
            for (Goblins goblin : goblins) {
                if(goblin.getGoblinCoords() == coords) {
                    return true;
                }
            }
        }
        return false;
    }

    public void startBattle(Humans player, Goblins goblin) {
        while(!goblin.checkDeath() && !player.checkDeath()) {
            player.attack(goblin);
            if(!goblin.checkDeath()) {
                goblin.attack(player);
            }
        }
        if(goblin.checkDeath()) {
            String str = goblin.dropItem();
            System.out.println("\n The goblin dropped a " + str + " on death!\n");
            player.addInv(str);
        }

    }

    /* THE PLAYER */
    public void playGame() {
        Humans player = new Humans();

        setupGoblins();
        try(Scanner input = new Scanner(System.in)) {
            String str = "";
            while (!player.checkDeath() && !checkGoblinsDead()) {
                displayMap();

                //display
                System.out.println("\n your position: " + Arrays.toString(playerCords));
                System.out.println("\n Map Keys: P = Player, G = Goblin\n");
                System.out.println("Enter n, s, e, w to go North, South, East, or West");
                System.out.println("Press h to see current health, and i for inventory.");

                str = input.next();
                if(str.equals("h")) {
                    System.out.println("\nYour current hp is " + player.getHumanHP() +"\n");
                } else if (str.equals("i")) {
                    System.out.println("Current inventory: ");
                    player.checkInventory();
                } else {
                    movePlayer(str);
                }

                //checks to see if battle time
                for (Goblins goblin: goblins) {
                    //System.out.println("Aim for: " + Arrays.toString(goblin.getGoblinCoords()));
                    if(Arrays.equals(goblin.getGoblinCoords(), playerCords) && !goblin.checkDeath()) {
                        startBattle(player, goblin);
                    }
                }

            }
            if(player.checkDeath()) {
                System.out.println("\n You have been slain!\n");
                System.out.println("\nCongratulations, you lost!\n");
            }
            else {
                System.out.println("\n You slayed all the goblins!\n");
                System.out.println("\n You finished with " + player.checkCoinBalance() + " coins!\n");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
