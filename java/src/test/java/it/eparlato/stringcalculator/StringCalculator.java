package it.eparlato.stringcalculator;

import java.util.List;

public class StringCalculator {

    private final NumbersExtractor numbersExtractor;

    public StringCalculator(NumbersExtractor numbersExtractor) {
        this.numbersExtractor = numbersExtractor;
    }

    public int add(String numbers) {

        List<Integer> numbersList = numbersExtractor.extractNumbers(numbers);

        validateNumbers(numbersList);

        return sumNumbers(numbersList);
    }

    private void validateNumbers(List<Integer> numbersList) {
        for (int number : numbersList) {
            if (number < 0) {
                throw new IllegalArgumentException("negatives not allowed: " + number);
            }
        }
    }

    private int sumNumbers(List<Integer> numbers) {
        int result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }
}
