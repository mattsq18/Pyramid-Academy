import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    Hangman hangman;

    @BeforeEach
    void setUp() {
        hangman = new Hangman();
        hangman.startGame();
    }

    @Test
    void getErrors() {
        assertEquals(0, hangman.getNumErrors());
    }

    @Test
    void getErrors2() {
        for(int j = 0; j < 8; j++) {
            hangman.guess(String.valueOf(j));
        }
        assertEquals(8, hangman.getNumErrors());
    }

    @Test
    void getErrors3() {
        hangman.guess("c");
        hangman.guess("a");
        hangman.guess("t");
        /*String input = "c";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);*/
        assertEquals(0, hangman.getNumErrors());
    }

    @Test
    void wonGame(){
        hangman.guess("c");
        hangman.guess("t");
        hangman.guess("a");

        assertTrue(hangman.wordFound());
    }

    @Test
    void correctDisplay() {
        hangman.guess("a");
        hangman.guess("b");
        hangman.guess("x");
        hangman.guess("gsegw");
        assertEquals(" +---+\n     |\n     |\n     |\n    ===", hangman.updateDisplay(0));
    }

    @Test
    void getCharArray() {
        //GIVES FAIL BUT IS EQUAL
        char[] blankArr = {'_','_','_'};
        assertEquals(blankArr, hangman.getHiddenArray());
    }

    @Test
    void getCharArray2() {
        //GIVES FAIL BUT IS EQUAL
        char[] partialArr = {'_','a','_'};
        hangman.guess("a");
        assertEquals(partialArr, hangman.getHiddenArray());
    }

    @AfterEach
    void tearDown() {
    }
}