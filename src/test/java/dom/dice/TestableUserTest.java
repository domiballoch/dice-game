package dom.dice;

import dom.dice.testable.TestableUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Comment out run methods in LuckySevensApplication before running tests
 * user.welcome();
 * user.userInput();
 */
@SpringBootTest
public class TestableUserTest {

    @Autowired
    private TestableUser testableUser;

    @BeforeEach
    public void setup() {
        testableUser.setMyBalance(100);
    }

    @Test
    public void testLuckSevens() {
        //set test data (bet, guess, random)
        testableUser.setMyBet(10);
        testableUser.setMyGuess(6);
        testableUser.setMyRandom(7);

        //class under test
        testableUser.testableInput();

        //result
        final int result = testableUser.getMyBalance();

        //Assertion
        Assertions.assertEquals(170, result);
    }

    @Test
    public void testSnakeEyes() {
        //set test data (bet, guess, random)
        testableUser.setMyBet(10);
        testableUser.setMyGuess(3);
        testableUser.setMyRandom(2);

        //class under test
        testableUser.testableInput();

        //result
        final int result = testableUser.getMyBalance();

        //Assertion
        Assertions.assertEquals(120, result);
    }

    @Test
    public void testStandardWin() {
        //set test data (bet, guess, random)
        testableUser.setMyBet(10);
        testableUser.setMyGuess(4);
        testableUser.setMyRandom(4);

        //class under test
        testableUser.testableInput();

        //result
        final int result = testableUser.getMyBalance();

        //Assertion
        Assertions.assertEquals(210, result);
    }

    @Test
    public void testLose() {
        //set test data (bet, guess, random)
        testableUser.setMyBet(10);
        testableUser.setMyGuess(7);
        testableUser.setMyRandom(12);

        //class under test
        testableUser.testableInput();

        //result
        final int result = testableUser.getMyBalance();

        //Assertion
        Assertions.assertEquals(90, result);
    }

    @Test
    public void testBetException() {
        //set test data (bet)
        testableUser.setMyBet(200);

        final Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            testableUser.testableInput();
        });
        final String expectedMessage = "Invalid bet!";
        final String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGuessException() {
        //set test data (bet, guess)
        testableUser.setMyBet(10);
        testableUser.setMyGuess(1);

        final Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            testableUser.testableInput();
        });
        final String expectedMessage = "Invalid guess!";
        final String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testOutOfFundsException() {
        //set test data (bet, guess, random)
        testableUser.setMyBet(100);
        testableUser.setMyGuess(5);
        testableUser.setMyRandom(12);

        final Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            testableUser.testableInput();
        });
        final String expectedMessage = "Out of funds";
        final String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
