package money;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Math.min;

public class DebtCalculator {
    private HashMap<String, Integer> debt;

    public static ArrayList<String> readFile(String filename) {
        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public DebtCalculator(String filename) {
        ArrayList<String> lines = readFile(filename);
        debt = new HashMap<>();
        for (String l : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(l.split(",")));
            String person1 = splits.get(0);
            String person2 = splits.get(1);
            //String amount = splits.get(2);
            int amount = Integer.parseInt(splits.get(2));
            if (!debt.containsKey(person1)) {
                debt.put(person1, 0);
            }
            if (!debt.containsKey(person2)) {
                debt.put(person2, 0);
            }
            debt.put(person1, debt.get(person1) - amount);
            debt.put(person2, debt.get(person2) + amount);
        }
    }

    public int netGains(String person) {
        // TODO
        return debt.get(person);
    }

    public boolean DFS(String person, HashSet<String> visited, Stack<String> st) {
        visited.add(person);
        st.push(person);
        String filename = "data/money.csv";
        ArrayList<String> lines = readFile(filename);
        for (String l : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(l.split(",")));
            String person1 = splits.get(0);
            String person2 = splits.get(1);
            int amount = Integer.parseInt(splits.get(2));
            while (!st.isEmpty()) {
                String curr = st.pop();
                if (person1.equals(curr) && person2.equals(curr)) {
                    visited.add(curr);
                    st.push(curr);
                }
                else{

                }
            }
        }
        st.pop(); // causes error if empty
        return false;
    }

        public Cycle findCycle () {
            HashSet<String> visited2 = new HashSet<>();
            Stack<String> st2 = new Stack<>();

            for (String s : debt.keySet()) {
                if (DFS(s, visited2, st2)) {
                    Cycle c = new Cycle(new ArrayList<String>(), debt.get(s));
                    return c;
                }
            }
            return null;
        }
}