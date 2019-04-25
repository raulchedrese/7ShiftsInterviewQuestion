package test.seven_shifts;

import com.seven_shifts.IStringCalculator;
import com.seven_shifts.calculators.Part3CustomDelimiterCalculator;
import org.junit.Test;

import java.util.Hashtable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Part3CustomDelimiterCalculatorTest {
    @Test
    public void testTextWithDelimiterOnlyStringResult() {
        // Remark: I am assuming that the header of the text is always in correct format and contains "\n"
        IStringCalculator calculator = new Part3CustomDelimiterCalculator();
        int result = calculator.add("//;\n");

        assertEquals(0, result);
    }

    @Test
    public void testCorrectStringResult() {
        // Note that this could also be done with parameterized test, but let's keep things simple.
        Hashtable<String, Integer> examples = getSetOfExamplesWithResult();

        IStringCalculator calculator = new Part3CustomDelimiterCalculator();

        for (String text : examples.keySet()) {
            int expected = examples.get(text);
            int actual = calculator.add(text);

            assertEquals(expected, actual);
        }
    }

    private Hashtable<String, Integer> getSetOfExamplesWithResult() {
        Hashtable<String, Integer> examples = new Hashtable<>();
        examples.put("//;\n1", 1); // Test single number with single digit
        examples.put("//;\n12", 12); // Test single number with multiple digits
        examples.put("//,\n12,26", 38); // Test 2 numbers
        examples.put("//@\n10@24@60", 94); // Test 3 numbers

        examples.put("//;\n1;3;4", 8); // Test the example in specification
        examples.put("//$\n1$2$3", 6); // Test the example in specification
        examples.put("//@\n2@3@8", 13); // Test the example in specification
        examples.put("//***\n1***2***3", 6); // Test for bonus question 2

        return examples;
    }

    @Test
    public void testIncorrectStringResult() {
        // Note that this could also be done with parameterized test, but let's keep things simple.
        // Making sure of the code returning wrong result is as important as making sure of the correct
        // results

        Hashtable<String, Integer> examples = getSetOfExamplesWithResult();

        IStringCalculator calculator = new Part3CustomDelimiterCalculator();

        for (String text : examples.keySet()) {
            int wrongAnswer = examples.get(text) + 1; // +1 to make sure it is not the correct answer
            int actual = calculator.add(text);

            assertNotEquals(wrongAnswer, actual);
        }

    }

}
