package test.seven_shifts;

import com.seven_shifts.IStringCalculator;
import com.seven_shifts.calculators.Part2IgnoreNewLineCalculator;
import org.junit.Test;

import java.util.Hashtable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Part2IgnoreNewLineCalculatorTest {
    @Test
    public void testEmptyStringResult() {
        IStringCalculator calculator = new Part2IgnoreNewLineCalculator();
        int result = calculator.add("");

        assertEquals(0, result);
    }

    @Test
    public void testNewLineOnlyStringResult() {
        IStringCalculator calculator = new Part2IgnoreNewLineCalculator();
        int result = calculator.add("\n");

        assertEquals(0, result);
    }

    @Test
    public void testCorrectStringResult() {
        // Note that this could also be done with parameterized test, but let's keep things simple.
        Hashtable<String, Integer> examples = getSetOfExamplesWithResult();

        IStringCalculator calculator = new Part2IgnoreNewLineCalculator();

        for (String text : examples.keySet()) {
            int expected = examples.get(text);
            int actual = calculator.add(text);

            assertEquals(expected, actual);
        }
    }

    private Hashtable<String, Integer> getSetOfExamplesWithResult() {
        Hashtable<String, Integer> examples = new Hashtable<>();
        examples.put("\n1\n", 1); // Test single number with single digit, leading and trailing new lines
        examples.put("12\n\n", 12); // Test single number with multiple digits
        examples.put("12\n,26\n\n", 38); // Test 2 numbers
        examples.put("10\n,\n24\n\n,\n60", 94); // Test 3 numbers
        examples.put("1\n,2,3", 6); // Test the example in specification
        examples.put("1,\n2,4", 7); // Test the example in specification

        return examples;
    }

    @Test
    public void testIncorrectStringResult() {
        // Note that this could also be done with parameterized test, but let's keep things simple.
        // Making sure of the code returning wrong result is as important as making sure of the correct
        // results

        Hashtable<String, Integer> examples = getSetOfExamplesWithResult();

        IStringCalculator calculator = new Part2IgnoreNewLineCalculator();

        for (String text : examples.keySet()) {
            int wrongAnswer = examples.get(text) + 1; // +1 to make sure it is not the correct answer
            int actual = calculator.add(text);

            assertNotEquals(wrongAnswer, actual);
        }

    }
}
