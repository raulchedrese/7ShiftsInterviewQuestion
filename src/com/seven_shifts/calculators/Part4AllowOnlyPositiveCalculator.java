package com.seven_shifts.calculators;

import com.seven_shifts.IStringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Implementation to support the forth question. Specification:
 *
 * Calling add with a negative number should throw an exception: “Negatives not allowed”.
 * The exception should list the number(s) that caused the exception
 */
public class Part4AllowOnlyPositiveCalculator implements IStringCalculator {
    private final int MIN_SUPORTED_VALUE = 0;

    @Override
    public int add(String text) {
        String delimiter = getStringDelimiter(text);
        text = getMainTextToCalculate(text);

        // From this part onward, it becomes like question 3, so I just copied the code with minor changes
        int result = 0;

        if (!text.equals("")) {
            /*
             * Pattern.quote is used to make sure a correct split occurs. For example, if the delimiter is $, a regular
             * split will consider it as a regular expression (representing the end of line).
             */
            int[] numbers = toIntegerArray(text.split(Pattern.quote(delimiter)));

            List<Integer> invalidNumbers = getInvalidNumbersInList(numbers);
            if (invalidNumbers.size() == 0) {
                // No invalid number, proceed as usual
                for (int number : numbers) {
                    result += number;
                }
            } else {
                // Negative number found, should throw an exception
                String message = String.format("Invalid number(s) in input: %s", getInvalidNumbersAsString(invalidNumbers));
                throw new RuntimeException(message);
            }
        }

        return result;
    }

    /**
     * Helper method to create a user friendly exception message.
     */
    private String getInvalidNumbersAsString(List<Integer> invalidNumbers) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < invalidNumbers.size(); i++) {
            if (invalidNumbers.size() > 1) {
                if (i == invalidNumbers.size() - 1) {
                    result.append(" and ");
                } else if (i > 0) {
                    result.append(", ");
                }
            }

            result.append(invalidNumbers.get(i));
        }

        return result.toString();
    }

    /**
     * Get a list of invalid number, in this case negative ones.
     */
    private List<Integer> getInvalidNumbersInList(int[] numbers) {
        List<Integer> result = new ArrayList<>();

        for (int number : numbers) {
            if (number < MIN_SUPORTED_VALUE) {
                result.add(number);
            }
        }

        return result;
    }

    /**
     * Convert array of strings to array of integers.
     */
    private int[] toIntegerArray(String[] parts) {
        int[] result =  new int[parts.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.valueOf(parts[i]);
        }

        return result;
    }

    /**
     * Removes the custom delimiter portion.
     * @param text Input text
     * @return The text part after definition of delimiter.
     */
    private String getMainTextToCalculate(String text) {
        return text.substring(text.indexOf("\n") + 1);
    }

    /**
     * Gets the delimiter defined at the beginning of text.
     * @param text Input text
     * @return Custom defined delimiter.
     */
    private String getStringDelimiter(String text) {
        String result = text.substring(0, text.indexOf("\n"));
        result = result.substring(2); // removing the // at the beginning.
        return result;
    }
}
