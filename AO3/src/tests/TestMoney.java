package tests;

import money.Cycle;
import money.DebtCalculator;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestMoney {

    @Test
    public void testNetGains(){
        String filename = "data/money.csv";
        DebtCalculator actual = new DebtCalculator(filename);
        assertEquals(-25, actual.netGains("Leo"));
        // TODO
    }
    @Test
    public void testFindCycle() {
        String filename = "data/money.csv";
        DebtCalculator d = new DebtCalculator(filename);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Paul");
        expected.add("Jesse");
        expected.add("Leo");
        Cycle actual = d.findCycle();
        assertEquals(expected, actual.getPeopleInCycle());
        assertEquals(25, actual.getCycleAmount());
    }


}
