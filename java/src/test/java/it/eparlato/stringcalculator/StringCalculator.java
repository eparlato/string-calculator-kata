package it.eparlato.stringcalculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringCalculator {

    private final NumbersExtractor numbersExtractor;

    public StringCalculator(NumbersExtractor numbersExtractor) {
        this.numbersExtractor = numbersExtractor;
    }

    public int add(String numbers) {

        List<Integer> numbersList = numbersExtractor.extractNumbers(numbers);

        checkForNegativeNumbers(numbersList);

        return sumNumbers(numbersList);
    }

    private void checkForNegativeNumbers(List<Integer> numbersList) {
        List<Integer> negativeNumbers = new ArrayList<Integer>();

        for (int number : numbersList) {
            if (number < 0) {
                negativeNumbers.add(number);
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + formatNegativeNumbersForErrorMessage(negativeNumbers));
        }
    }

    private String formatNegativeNumbersForErrorMessage(List<Integer> numbers) {
        StringBuilder stringOfNumbers = new StringBuilder();

        for (int index = 0; index < numbers.size(); index++) {
            stringOfNumbers.append(numbers.get(index));

            if(index != numbers.size() - 1) {
                stringOfNumbers.append(", ");
            }
        }

        return stringOfNumbers.toString();
    }

    private int sumNumbers(List<Integer> numbers) {
        int result = 0;

        for (int number : numbers) {

            if (number > 1000) {
                continue;
            }

            result += number;
        }

        return result;
    }
}
