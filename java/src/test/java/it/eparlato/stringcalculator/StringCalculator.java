package it.eparlato.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {

        List<Integer> numbersList = extractNumbersFromString(numbers);

        return sumNumbers(numbersList);
    }

    private List<Integer> extractNumbersFromString(String input) {
        List<Integer> numbers = new ArrayList<Integer>();

        if (input.isEmpty()) {
            return numbers;
        }

        String numberSeparator = ",";

        input = input.replace("\n", numberSeparator);

        String[] numbersSplitOnNumberSeparator = input.split(numberSeparator);

        for (String numberAsString : numbersSplitOnNumberSeparator) {
            numbers.add(Integer.parseInt(numberAsString.trim()));
        }

        return numbers;
    }

    private int sumNumbers(List<Integer> numbers) {
        int result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }
}
