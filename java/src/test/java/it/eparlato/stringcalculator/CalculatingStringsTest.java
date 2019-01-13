package it.eparlato.stringcalculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class CalculatingStringsTest {
    public static class WhenAStringContainsNumbers {

        private StringCalculator stringCalculator = new StringCalculator(new ConcreteNumbersExtractor());

        public @Rule ExpectedException negativeNumberException = ExpectedException.none();

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

        @Test
        public void weCanSumAnUnknownAmountOfNumbers() {
            assertEquals(19, stringCalculator.add("1, 10, 5, 3"));
        }

        @Test
        public void weCanSumNumbersSeparatedByNewLines() {
            assertEquals(6, stringCalculator.add("1\n2,3"));
        }

        @Test
        public void weCanChangeTheNumbersDelimiterInTheFirstStringRow() {
            assertEquals(3, stringCalculator.add("//;\n1;2"));
        }

        @Test
        public void weShowAnErrorMessageIfThereIsANegativeNumber() {
            negativeNumberException.expect(IllegalArgumentException.class);
            negativeNumberException.expectMessage("negatives not allowed: -1");

            stringCalculator.add("1,4,-1");
        }


    }

}
