package Chapter9;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExploreAssertions {

    static int num1, num2;

    @BeforeAll
    static void setup(){
        num1 = 5;
        num2 = 3;
    }


    @Test
    void testSumOfTwoNumbers(){
        //Arrange
        int expected = 8;

        //Act - Actual computation
        int actual = num1 + num2;

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void testDiffOfTwoNumbers(){
        int expected = 2;

        int actual = num1 - num2;
    }

    @Test
            @DisplayName("Compute sum, difference and product")
    void testComputationOfTwoNumbers(){
        //Arrange
        int expectedSum = 8;
        int expectedDiff = 2;
        int expectedProduct = 15;

        int actualSum = num1 + num2 + 1;//fail
        int actualDiff = num1 - num2;
        int actualProduct = num1 * num2 + 1;//fail

        assertAll(
                () -> assertEquals(expectedSum, actualSum),
                () -> assertEquals(expectedDiff, actualDiff),
                () -> assertEquals(expectedProduct, actualProduct)
        );

    }
}
