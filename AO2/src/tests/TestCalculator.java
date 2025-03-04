package tests;

import calculator.model.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCalculator {

    @Test
    public void testCalc1() {
        Calculator calc = new Calculator();
        calc.numberPressed(10);
        calc.addPressed();
        calc.numberPressed(5);
        calc.equalsPressed();
        assertEquals(15.0, calc.displayNumber());
    }

}
