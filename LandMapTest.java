import static org.junit.jupiter.api.Assertions.*;

class LandMapTest {
    LandMap landMap;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @org.junit.jupiter.api.Test
    void getSize() {
        landMap = new LandMap();
        assertEquals(10, landMap.getSize());
    }

    @org.junit.jupiter.api.Test
    void getSize2() {
        landMap = new LandMap(20);
        assertEquals(20, landMap.getSize());
    }


    @org.junit.jupiter.api.Test
    void getNumGoblins() {
        landMap = new LandMap();
        assertEquals(5, landMap.getNumGoblins());
    }

    @org.junit.jupiter.api.Test
    void getNumGoblins2() {
        landMap = new LandMap(15, 10);
        assertEquals(10, landMap.getNumGoblins());
    }


    //TEST FAILED BUT DOES EQUAL, ARRAYS ARE STRANGE
    @org.junit.jupiter.api.Test
    void getPlayerCords() {
        landMap = new LandMap();
        assertEquals(new int[] {0,0}, landMap.getPlayerCords());
    }

    @org.junit.jupiter.api.Test
    void checkGoblinsDead() {
        landMap = new LandMap();
        assertTrue(landMap.checkGoblinsDead());
    }

    @org.junit.jupiter.api.Test
    void checkGoblinsDead2() {
        landMap = new LandMap();
        landMap.setupGoblins();
        assertFalse(landMap.checkGoblinsDead());
    }



    @org.junit.jupiter.api.Test
    void isOccupied() {
        landMap = new LandMap();

    }

    @org.junit.jupiter.api.Test
    void startBattle() {
        landMap = new LandMap();
        Humans human = new Humans(250);
        Goblins goblin = new Goblins(1);
        landMap.startBattle(human, goblin);
        assertTrue(goblin.checkDeath());
    }

    @org.junit.jupiter.api.Test
    void startBattle2() {
        landMap = new LandMap();
        Humans human = new Humans(1);
        Goblins goblin = new Goblins(100);
        landMap.startBattle(human, goblin);
        assertTrue(human.checkDeath());
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
}