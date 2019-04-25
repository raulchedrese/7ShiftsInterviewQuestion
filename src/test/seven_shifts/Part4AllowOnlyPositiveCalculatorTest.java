package test.seven_shifts;

import com.seven_shifts.IStringCalculator;
import com.seven_shifts.calculators.Part4AllowOnlyPositiveCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

public class Part4AllowOnlyPositiveCalculatorTest {
    @Test
    public void testTextWithDelimiterOnlyStringResult() {
        // Remark: I am assuming that the header of the text is always in correct format and contains "\n"
        IStringCalculator calculator = new Part4AllowOnlyPositiveCalculator();
        int result = calculator.add("//;\n");

        assertEquals(0, result);
    }

    @Test
    public void testCorrectStringResult() {
        // Note that this could also be done with parameterized test, but let's keep things simple.
        Hashtable<String, Integer> examples = getSetOfCorrectExamplesWithResult();

        IStringCalculator calculator = new Part4AllowOnlyPositiveCalculator();

        for (String text : examples.keySet()) {
            int expected = examples.get(text);
            int actual = calculator.add(text);

            assertEquals(expected, actual);
        }
    }

    @Test
    public void testStringResultWithNegativeValues() {
        // Note that this could also be done with parameterized test, but let's keep things simple.
        List<String> examples = getSetOfInvalidExamplesWithResult();

        IStringCalculator calculator = new Part4AllowOnlyPositiveCalculator();

        for (String text : examples) {
            try {
                calculator.add(text);
                fail();
            } catch (RuntimeException ex) {
                // Just make sure the exception is related to negative values, not some other issues.
                Assert.assertTrue(ex.getMessage().startsWith("Invalid number(s) in input: "));
            } catch (Exception ex) {
                fail();
            }
        }
    }

    private Hashtable<String, Integer> getSetOfCorrectExamplesWithResult() {
        Hashtable<String, Integer> examples = new Hashtable<>();

        examples.put("//;\n1", 1); // Test single number with single digit
        examples.put("//;\n12", 12); // Test single number with multiple digits
        examples.put("//@\n10@24@60", 94); // Test 3 numbers
        examples.put("//,\n12,26", 38); // Test 2 numbers

        examples.put("//;\n1;3;4", 8); // Test the example in specification
        examples.put("//$\n1$2$3", 6); // Test the example in specification
        examples.put("//@\n2@3@8", 13); // Test the example in specification

        return examples;
    }

    private List<String> getSetOfInvalidExamplesWithResult() {
        ArrayList<String> examples = new ArrayList<>();

        examples.add("//@\n10@24@-60"); // Test invalid string
        examples.add("//@\n10@24@-60@-20"); // Test invalid string
        examples.add("//@\n10@24@-60@-20@-40"); // Test invalid string

        return examples;
    }

    @Test
    public void testIncorrectStringResult() {
        // Note that this could also be done with parameterized test, but let's keep things simple.
        // Making sure of the code returning wrong result is as important as making sure of the correct
        // results

        Hashtable<String, Integer> examples = getSetOfCorrectExamplesWithResult();

        IStringCalculator calculator = new Part4AllowOnlyPositiveCalculator();

        for (String text : examples.keySet()) {
            int wrongAnswer = examples.get(text) + 1; // +1 to make sure it is not the correct answer
            int actual = calculator.add(text);

            assertNotEquals(wrongAnswer, actual);
        }

    }
}
