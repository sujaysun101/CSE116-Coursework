package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestProblemSet {

    // First method
    private final double EPSILON = 0.001;
    public void compareDoubles(double d1, double d2) {
        assertTrue(Math.abs(d1 - d2) < EPSILON);
    }
    @Test
    public void testDoublesAllPositive() {
        ArrayList<Double> number1 = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0));

        double numbers = ProblemSet.average(number1);
        compareDoubles(numbers, 2.0);
    }

    @Test
    public void testDoublesNegative() {
        ArrayList<Double> number1 = new ArrayList<>(Arrays.asList(-5.0,-5.0));

        double numbers = ProblemSet.average(number1);
        compareDoubles(numbers, -5.0);
    }

    @Test
    public void testDoublesPartialNegative() {
        ArrayList<Double> number1 = new ArrayList<>(Arrays.asList(-5.0,5.0));

        double numbers = ProblemSet.average(number1);
        compareDoubles(numbers, 0.0);
    }

    @Test
    public void testDoublesZero() {
        ArrayList<Double> number1 = new ArrayList<>(Arrays.asList(0.0));

        double numbers = ProblemSet.average(number1);
        compareDoubles(numbers, 0.0);
    }

    @Test
    public void testDoublesDecimal() {
        ArrayList<Double> number1 = new ArrayList<>(Arrays.asList(6.5,6.5,8.5,8.5));

        double numbers = ProblemSet.average(number1);
        compareDoubles(numbers, 7.5);
    }

    @Test
    public void testDoublesNegativeAndDecimal() {
        ArrayList<Double> number1 = new ArrayList<>(Arrays.asList(6.5,-6.5,-8.5,7.5));

        double numbers = ProblemSet.average(number1);
        compareDoubles(numbers, -0.25);
    }

    @Test
    public void testDoublesOneElement() {
        ArrayList<Double> number1 = new ArrayList<>(Arrays.asList(1.0));

        double numbers = ProblemSet.average(number1);
        compareDoubles(numbers, 1.0);
    }

    //Second Method
    @Test
    public void testSumOfPositiveDigits() {

        System.out.println(ProblemSet.sumOfDigits(123));
        System.out.println(ProblemSet.sumOfDigits(57));
        System.out.println(ProblemSet.sumOfDigits(36));

        assertTrue(ProblemSet.sumOfDigits(123) == 6);
        assertTrue(ProblemSet.sumOfDigits(57) == 12);
        assertTrue(ProblemSet.sumOfDigits(36) == 9);

    }

    @Test
    public void testSumOfNegativeDigits() {

        System.out.println(ProblemSet.sumOfDigits(-123));
        System.out.println(ProblemSet.sumOfDigits(-57));
        System.out.println(ProblemSet.sumOfDigits(-36));

        assertTrue(ProblemSet.sumOfDigits(-123) == 6);
        assertTrue(ProblemSet.sumOfDigits(-57) == 12);
        assertTrue(ProblemSet.sumOfDigits(-36) == 9);

    }

    @Test
    public void testSumOfIncreasingDigits() {

        System.out.println(ProblemSet.sumOfDigits(1234));
        System.out.println(ProblemSet.sumOfDigits(148));
        System.out.println(ProblemSet.sumOfDigits(12));

        assertTrue(ProblemSet.sumOfDigits(1234) == 10);
        assertTrue(ProblemSet.sumOfDigits(148) == 13);
        assertTrue(ProblemSet.sumOfDigits(12) == 3);

    }

    @Test
    public void testSumOfDecreasingDigits() {

        System.out.println(ProblemSet.sumOfDigits(84));
        System.out.println(ProblemSet.sumOfDigits(987));
        System.out.println(ProblemSet.sumOfDigits(7534));

        assertTrue(ProblemSet.sumOfDigits(84) == 12);
        assertTrue(ProblemSet.sumOfDigits(987) == 24);
        assertTrue(ProblemSet.sumOfDigits(7534) == 19);

    }

    @Test
    public void testSumOfRandomDigits() {

        System.out.println(ProblemSet.sumOfDigits(1576930));
        System.out.println(ProblemSet.sumOfDigits(376));
        System.out.println(ProblemSet.sumOfDigits(58460));

        assertTrue(ProblemSet.sumOfDigits(1576930) == 31);
        assertTrue(ProblemSet.sumOfDigits(376) == 16);
        assertTrue(ProblemSet.sumOfDigits(58460) == 23);

    }

    @Test
    public void testSumOfJustZero() {
        System.out.println(ProblemSet.sumOfDigits(0));
        assertTrue(ProblemSet.sumOfDigits(0) == 0);
    }

    //Third Method
    @Test
    public void testBestKey() {
        HashMap<String, Integer> bK = new HashMap<>();
        bK.put("CSE", 100);
        bK.put("MTH", 90);
        bK.put("MGT", 10);

        String key = ProblemSet.bestKey(bK);

        assertEquals(key, "CSE");
    }

    @Test
    public void testTwoBestKeys() {
        HashMap<String, Integer> bK = new HashMap<>();
        bK.put("cat", 5);
        bK.put("dog", 5);
        bK.put("fox", 4);

        String key = ProblemSet.bestKey(bK);
        System.out.println(key);
        assertTrue(key == "cat" || key == "dog");
    }

    @Test
    public void testBestKeyWithNegatives() {
        HashMap<String, Integer> bK = new HashMap<>();
        bK.put("CSE", -99);
        bK.put("MTH", -100);
        bK.put("MGT", -3);

        String key = ProblemSet.bestKey(bK);
        System.out.println(key);
        assertEquals(key, "MGT");
    }

    @Test
    public void testEmpty() {
        HashMap<String, Integer> bK = new HashMap<>();

        String key = ProblemSet.bestKey(bK);

        assertTrue(key.equals(""));
    }



    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class


}