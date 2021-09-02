package MoreOrLess;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MainTest {
    @Test
    public void rand() {
        Model testModel = new Model();
        testModel.setMinLimit(0);
        testModel.setMaxLimit(100);
        int randomNumber;
        for (int i = 0; i < 100000; i++) {
            randomNumber = testModel.rand();
            boolean correct = (randomNumber > 0 && randomNumber < 100);
            assertTrue(correct);
        }

    }
}
