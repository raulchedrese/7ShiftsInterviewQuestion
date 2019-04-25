package com.seven_shifts.calculators;

import com.seven_shifts.IStringCalculator;

/**
 * Implementation to support second question. Specification:
 *
 * Change the Add method to handle new lines in the input format
 *    a. Example: “1\n,2,3” - Result: “6”
 *    b. Example 2: “1,\n2,4” - Result: “7”
 */
public class Part2IgnoreNewLineCalculator implements IStringCalculator {
    @Override
    public int add(String text) {
        // The only difference between this part and the previous one is to ignore the new lines, the
        // easiest way is to just remove them and proceed like part one.
        text = text.replace("\n", "");

        // Note that I could use the method from Part1SimplestCalculator.add(), but the question wants
        // to change the code incrementally.
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
