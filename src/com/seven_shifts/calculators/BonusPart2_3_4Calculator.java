package com.seven_shifts.calculators;

import com.seven_shifts.IStringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class BonusPart2_3_4Calculator implements IStringCalculator {
    @Override
    public int add(String text) {
        List<String> delimiters = getStringDelimiters(text);
        text = getMainTextToCalculate(text);

        int result = 0;

        if (!text.equals("")) {
            String regex = getSplitOnDelimitersRegEx(delimiters);
            String[] parts = text.split(regex);

            for (String part : parts) {
                result += Integer.valueOf(part);
            }
        }

        return result;
    }

    /**
     * Combines each delimiter's pattern to make a regex that recognizes them all.
     */
    private String getSplitOnDelimitersRegEx(List<String> delimiters) {
        StringBuilder result = new StringBuilder();
        String regExDelimiter = "";

        for (String delimiter : delimiters) {
            result.append(regExDelimiter);
            result.append(Pattern.quote(delimiter));

            regExDelimiter = "|";
        }

        return result.toString();
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
     * Gets the delimiters defined at the beginning of text.
     * @param text Input text
     * @return Custom defined delimiters.
     */
    private List<String> getStringDelimiters(String text) {
        String result = text.substring(0, text.indexOf("\n"));
        result = result.substring(2); // removing the // at the beginning.

        return Arrays.asList(result.split(","));
    }

}
