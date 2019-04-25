package test.seven_shifts;

import com.seven_shifts.IStringCalculator;
import com.seven_shifts.calculators.BonusPart2_3_4Calculator;
import org.junit.Test;

import java.util.Hashtable;

import static org.junit.Assert.assertEquals;

public class BonusPart2_3_4CalculatorTest {
    @Test
    public void testCorrectStringResult() {
        // Note that this could also be done with parameterized test, but let's keep things simple.
        Hashtable<String, Integer> examples = getSetOfExamplesWithResult();

        IStringCalculator calculator = new BonusPart2_3_4Calculator();

        for (String text : examples.keySet()) {
            int expected = examples.get(text);
            int actual = calculator.add(text);

            assertEquals(expected, actual);
        }
    }

    private Hashtable<String, Integer> getSetOfExamplesWithResult() {
        Hashtable<String, Integer> examples = new Hashtable<>();
        examples.put("//***\n1***2***3", 6);
        examples.put("//***,#\n1***2***3#4#1***3", 14);
        examples.put("//$,@\n1$2@3", 6);
        examples.put("//$$,@@\n1$$2@@3", 6);
        examples.put("//$$,@\n1$$4@3", 8);

        return examples;
    }
}
