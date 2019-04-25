package com.seven_shifts.calculators;

import com.seven_shifts.IStringCalculator;

import java.util.regex.Pattern;

/**
 * Implementation to support the third question. Specification:
 *
 * Support a custom delimiter
 *    a. The beginning of your string will now contain a small control code that lets you
 *       set a custom delimiter.
 *    b. Format: “//[delimiter]\n[delimiter separated numbers]”
 *    c. Example: “//;\n1;3;4” - Result: 8
 *    d. In the above you can see that following the double forward slash we set a
 *       semicolon, followed by a new line. We then use that delimiter to split our
 *       numbers.
 *    e. Other examples
 *        i. “//$\n1$2$3” - Result: 6
 *        ii. “//@\n2@3@8” - Result: 13
 */
public class Part3CustomDelimiterCalculator implements IStringCalculator {
    @Override
    public int add(String text) {
        /*
         * The way the question is formulated looks like the definition of a regular language. In a general case,
         * it is better to use a language parser such as ANTLR, but for the sake of simplicity and considering the
         * non-ambiguous format of the language, I will just use string operations.
         */

        String delimiter = getStringDelimiter(text);
        text = getMainTextToCalculate(text);

        // From this part onward, it becomes like question 2, so I just copied the code with minor changes
        // Note that because the problem wants to see the code for all parts, I did not refactored the method in a
        // super class or utils class.
        int result = 0;

        if (!text.equals("")) {
            /*
             * Pattern.quote is used to make sure a correct split occurs. For example, if the delimiter is $, a regular
             * split will consider it as a regular expression (representing the end of line).
             */
            String regex = Pattern.quote(delimiter);
            String[] parts = text.split(regex);

            for (String part : parts) {
                result += Integer.valueOf(part);
            }
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
