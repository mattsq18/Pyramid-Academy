import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class HangmanFunctionalTest {
    HangmanFunctional hangmanFunctional;
    @BeforeEach
    void setUp() {
        hangmanFunctional = new HangmanFunctional();
        hangmanFunctional.startGame();
    }

    @Test
    void getNumErrors() {
        assertEquals(0,hangmanFunctional.getNumErrors());
    }

    @Test
    void getNumErrors2() {

        for(int j = 0; j < 8; j++) {
                hangmanFunctional.guess(String.valueOf(j));
            }
            assertEquals(8, hangmanFunctional.getNumErrors());
    }


    @Test
    void getNumErrors3() {
        hangmanFunctional.guess("u");
        hangmanFunctional.guess("c");
        hangmanFunctional.guess("f");
        assertEquals(0, hangmanFunctional.getNumErrors());
    }

    @Test
    void wordFound() {
        assertFalse(hangmanFunctional.wordFound());
    }

    @Test
    void writeToFile() {
        try {
            hangmanFunctional.writeToFile("Joe", 0);
            assertEquals(0, hangmanFunctional.checkHighScore());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void checkHighScore() {
        assertEquals(5, hangmanFunctional.checkHighScore());
    }

    @Test
    void checkHighScore2() {
        try {
            hangmanFunctional.writeToFile("Matt", 5);
            assertEquals(5, hangmanFunctional.checkHighScore());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    @AfterEach
    void tearDown() {
    }

}