package test.seven_shifts;

import com.seven_shifts.IStringCalculator;
import com.seven_shifts.calculators.BonusPart1ExcludeLargeNumbersCalculator;
import org.junit.Test;

import java.util.Hashtable;

import static org.junit.Assert.assertEquals;

public class BonusPart1ExcludeLargeNumbersCalculatorTest {
    @Test
    public void testEmptyStringResult() {
        IStringCalculator calculator = new BonusPart1ExcludeLargeNumbersCalculator();
        int result = calculator.add("");

        assertEquals(0, result);
    }

    @Test
    public void testCorrectStringResult() {
        // Note that this could also be done with parameterized test, but let's keep things simple.
        Hashtable<String, Integer> examples = getSetOfExamplesWithResult();

        IStringCalculator calculator = new BonusPart1ExcludeLargeNumbersCalculator();

        for (String text : examples.keySet()) {
            int expected = examples.get(text);
            int actual = calculator.add(text);

            assertEquals(expected, actual);
        }
    }

    private Hashtable<String, Integer> getSetOfExamplesWithResult() {
        Hashtable<String, Integer> examples = new Hashtable<>();
        examples.put("2000,1", 1);
        examples.put("12", 12);
        examples.put("1500,12,24", 36);
        examples.put("10,24,50", 84);
        examples.put("1,2,5", 8);
        examples.put("1001,2,5", 7);

        return examples;
    }
}
