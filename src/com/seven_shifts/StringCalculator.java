package com.seven_shifts;

public interface StringCalculator {
    /**
     * Parses a string and returns the sum of numbers in the text. Please note that it is not common for
     * Java methods to start with an upper case letter, that is why I changed Add() to add().
     *
     * @param text The text input to be parsed.
     * @return The sum of numbers according to the specification.
     */
    int add(String text);
}
