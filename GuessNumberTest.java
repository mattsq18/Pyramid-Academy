import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class GuessNumberTest {

    GuessNumber gNumber;

    @BeforeEach
    void setUp() {
        gNumber = new GuessNumber();
    }

    @Test
    void setNumber() {
        gNumber.setRandNum(10);
        assertEquals(10, gNumber.getRandNum());
    }

    @Test
    void setName() {
        gNumber.setUserName("Steve");
        assertEquals("Steve", gNumber.getUserName());
    }

    @AfterEach
    void tearDown() {
    }


}