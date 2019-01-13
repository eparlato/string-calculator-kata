package it.eparlato.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteNumbersExtractor implements NumbersExtractor {
    public List<Integer> extractNumbers(String input) {
        List<Integer> numbers = new ArrayList<Integer>();

        if (input.isEmpty()) {
            return numbers;
        }

        String numberSeparator = extractNumberSeparator(input);

        input = clearInput(input, numberSeparator);

        String[] numbersStringArray = extractNumbersAsStringArray(input, numberSeparator);

        numbers = convertToIntegerList(numbersStringArray);

        return numbers;

    }

    private String extractNumberSeparator(String input) {
        if (input.startsWith("//")) {
            return input.substring(2, 3);
        }

        return ",";
    }

    private List<Integer> convertToIntegerList(String[] numbersStringArray) {
        List<Integer> numbers = new ArrayList<Integer>();

        for (String numberAsString : numbersStringArray) {
            numbers.add(Integer.parseInt(numberAsString));
        }

        return numbers;
    }

    private String[] extractNumbersAsStringArray(String input, String numberSeparator) {
        return input.split(numberSeparator);
    }

    private String clearInput(String input, String numberSeparator) {
        if (input.startsWith("//")) {
            int indexOfLineSeparator = input.indexOf("\n");

            input = input.substring(indexOfLineSeparator + 1);
        }

        input = input.replace("\n", numberSeparator);
        input = input.replace(" ", "");

        return input;
    }
}
