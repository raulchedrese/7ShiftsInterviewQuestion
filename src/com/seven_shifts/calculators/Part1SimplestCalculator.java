package com.seven_shifts.calculators;

import com.seven_shifts.StringCalculator;

/**
 * Implementation to support first question. Specification:
 *
 * Create a simple String calculator with a method: int Add(string numbers)
 *    a. The numbers in the string are separated by a comma.
 *    b. Empty strings should return 0.
 *    c. The return type should be an integer.
 *    d. Example input: “1,2,5” - expected result: “8”.
 *    e. Write tests to prove your input validates.
 */
public class Part1SimplestCalculator implements StringCalculator {
    @Override
    public int add(String text) {
        int result = 0;

        if (!text.equals("")) {
            String[] parts = text.split(",");

            for (String part : parts) {
                result += Integer.valueOf(part);
            }
        }

        return result;
    }
}
