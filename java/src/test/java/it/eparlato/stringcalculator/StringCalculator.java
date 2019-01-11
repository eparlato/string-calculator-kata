package it.eparlato.stringcalculator;

public class StringCalculator {
    public int add(String numbers) {

        String[] numbersAsStringArray = getNumbersFromString(numbers);

        int result = sumStringNumbers(numbersAsStringArray);

        return result;
    }

    private String[] getNumbersFromString(String numbers) {
        if (numbers.isEmpty()) {
            return new String[]{};
        }

        return numbers.split(",");
    }

    private int sumStringNumbers(String[] numbersSplitOnComma) {
        int result = 0;

        for (String numberAsString : numbersSplitOnComma) {
            result +=  Integer.parseInt(numberAsString.trim());
        }

        return result;
    }
}
