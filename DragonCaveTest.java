import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class DragonCaveTest {

    DragonCave dCave;

    @BeforeEach
    void setUp() {
        dCave = new DragonCave();
    }

    @Test
    void getEvilDragon() {
        dCave.setEvilDragon(1);
        assertEquals(1,dCave.getEvilDragon());
    }

    @Test
    void getRiggedGame() {
        dCave.setRiggedGame(true);
        assertTrue(dCave.getRiggedGame());
    }

    @Test
    void game() {
        dCave.setEvilDragon(1);
        dCave.setRiggedGame(true);

        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Gobbles you down in one bite!", dCave.game() );
    }

    @Test
    void gameTwo() {
        dCave.setEvilDragon(1);
        dCave.setRiggedGame(true);

        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Welcomes you into his cave and offers to share his treasure!", dCave.game() );
    }

    @Test
    void gameThree() {
        String input = "garbage";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("You suffer a heart attack from the stress of indecisiveness!", dCave.game() );
    }

    @AfterEach
    void tearDown() {
    }


}
