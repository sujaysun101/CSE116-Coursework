package ratings;

import javax.imageio.stream.ImageInputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet {


    public static double average(ArrayList<Double> numbers) {
        if (numbers.isEmpty()) {
            return 0.0;
        }
        else {
            double avg = 0.0;
            double total = 0.0;
            for (int i = 0; i < numbers.size(); i++) {
                total += numbers.get(i);
                avg = total / (i + 1);
            }
            return avg;

        }
        // TODO: Implement this method to return the average of all the numbers in the input ArrayList
        //       If the ArrayList is empty, return 0.0
        //
        // Examples
        // [1.0,2.0,3.0] returns 2.0
        // [-5.0,5.0] returns 0.0
        // [6.5,6.5,8.5,8.5] returns 7.5
        // [] returns 0.0

    }

public static int sumOfDigits(int num) {
    int total = 0;
    num = Math.abs(num);
    while (num > 0) {
        total += num % 10;
        num /= 10;
    }
    return total;

}
    // TODO: Write a public static method named sumOfDigits that takes an int as a parameter and
    //       returns the sum of the digits of the input as an int
    //
    // Examples
    // 123 returns 6
    // 57 returns 12
    // -36 returns 9
public static String bestKey(HashMap<String, Integer> KV) {
        if (KV.isEmpty()) {
            return "";
        }
        String k = "";
        int total = Integer.MIN_VALUE;
        for (String key : KV.keySet()) {
            //if the current value is greater than the stored total, reassign the key to the current key
            if (KV.get(key) >= total) {
                k = key;
                total = KV.get(key);
            }
            }
        return k;
        }

}

    // TODO: Write a public static method named bestKey that takes a HashMap of String to Integer
    //       as a parameter and returns a key mapping to the largest Integer. Ties can be broken arbitrarily.
    //       If the HashMap is empty, return the empty String
    //
    // Examples
    // {"CSE": 100, "MTH": 90, "MGT": 10} returns "CSE"
    // {"cat": 5, "dog": 5, "fox": 4} can return either "cat" or "dog"
    // {} returns ""







