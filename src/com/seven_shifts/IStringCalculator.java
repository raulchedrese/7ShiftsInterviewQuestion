package com.seven_shifts;

/**
 * Interface for string calculator.
 *
 * Although starting interface name with I is a C# convention, I tend to do it in Java since it is
 * easier to read codes and know that a type is a class or an interface.
 */
public interface IStringCalculator {
    /**
     * Parses a string and returns the sum of numbers in the text. Please note that it is not common for
     * Java methods to start with an upper case letter, that is why I changed Add() to add().
     *
     * @param text The text input to be parsed.
     * @return The sum of numbers according to the specification.
     */
    int add(String text);
}
