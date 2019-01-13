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

        if(input.startsWith("//")) {
            numberSeparator = input.substring(2, 3);
            int indexOfLineSeparator = input.indexOf("\n");

            input = input.substring(indexOfLineSeparator + 1);
        }


        input = clearInput(input, numberSeparator);

        String[] numbersStringArray = extractNumbersAsStringArray(input, numberSeparator);

        numbers = convertNumbersToIntegers(numbersStringArray);

        return numbers;
    }

    private List<Integer> convertNumbersToIntegers(String[] numbersStringArray) {
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
        input = input.replace("\n", numberSeparator);
        input = input.replace(" ", "");

        return input;
    }

    private int sumNumbers(List<Integer> numbers) {
        int result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }
}
