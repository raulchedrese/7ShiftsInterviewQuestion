package test.seven_shifts;

import com.seven_shifts.IStringCalculator;
import com.seven_shifts.calculators.Part1SimplestCalculator;
import org.junit.Test;

import java.util.Hashtable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Part1SimplestCalculatorTest {
    @Test
    public void testEmptyStringResult() {
        IStringCalculator calculator = new Part1SimplestCalculator();
        int result = calculator.add("");

        assertEquals(0, result);
    }

    @Test
    public void testCorrectStringResult() {
        // Note that this could also be done with parameterized test, but let's keep things simple.
        Hashtable<String, Integer> examples = getSetOfExamplesWithResult();

        IStringCalculator calculator = new Part1SimplestCalculator();

        for (String text : examples.keySet()) {
            int expected = examples.get(text);
            int actual = calculator.add(text);

            assertEquals(expected, actual);
        }
    }

    private Hashtable<String, Integer> getSetOfExamplesWithResult() {
        Hashtable<String, Integer> examples = new Hashtable<>();
        examples.put("1", 1); // Test single number with single digit
        examples.put("12", 12); // Test single number with multiple digits
        examples.put("12,24", 36); // Test 2 numbers
        examples.put("10,24,50", 84); // Test 3 numbers
        examples.put("1,2,5", 8); // Test the example in specification
        examples.put("1001,2,5", 1008); // Test the example with large number to make sure it has no conflict after bonus 1
        return examples;
    }

    @Test
    public void testIncorrectStringResult() {
        // Note that this could also be done with parameterized test, but let's keep things simple.
        // Making sure of the code returning wrong result is as important as making sure of the correct
        // results

        Hashtable<String, Integer> examples = getSetOfExamplesWithResult();

        IStringCalculator calculator = new Part1SimplestCalculator();

        for (String text : examples.keySet()) {
            int wrongAnswer = examples.get(text) + 1; // +1 to make sure it is not the correct answer
            int actual = calculator.add(text);

            assertNotEquals(wrongAnswer, actual);
        }

    }
}
