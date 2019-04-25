package com.seven_shifts.calculators;

/**
 * Implementation to support first bonus question. Specification:
 *
 * Numbers larger than 1000 should be ignored.
 *    a. Example “2,1001” - Result: 2
 */
public class BonusPart1ExcludeLargeNumbersCalculator extends Part1SimplestCalculator {
    /*
    Remarks: Instead of copying the same code from part 1, I just added a validation method and override it here.
     */


    public static final int MAX_ALLOWED_NUMBER = 1000;

    @Override
    protected boolean shouldNumberBeConsidered(int value) {
        return value <= MAX_ALLOWED_NUMBER;
    }
}

