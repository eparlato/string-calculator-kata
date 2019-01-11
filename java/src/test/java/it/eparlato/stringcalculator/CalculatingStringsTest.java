package it.eparlato.stringcalculator;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class CalculatingStringsTest {
    public static class WhenAStringContainsNumbers {

        private StringCalculator stringCalculator = new StringCalculator();

        @Test
        public void sumIsZeroIfTheStringIsEmpty() {
            assertEquals(0, stringCalculator.add(""));
        }

        @Test
        public void sumIsTheArgumentIfTheArgumentIsANumber() {
            assertEquals(2, stringCalculator.add("2"));
        }

        @Test
        public void weCanSumTwoNumbers() {
            assertEquals(5, stringCalculator.add("2, 3"));
        }



    }
}
