package tests;

import org.junit.Test;
import ratings.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClasses3 {
    public boolean compareRatableArrayLists(ArrayList<Ratable> i, ArrayList<Ratable> j) {
        TestDataStructures1 tDS1 = new TestDataStructures1();
        if (i.size() != j.size()) {
            return false;
        }
        for (int x = 0; x <= i.size() - 1; x++) {
            boolean flag = false;
            for (int y = 0; y <= j.size() - 1; y++) {
                if (i.get(x).getTitle().equals(j.get(y).getTitle())) {
                    flag = true;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testTopKRatables() {
        Song s1 = new Song("Ric Flair Drip (with Metro Boomin)", "Offset", "7sO5G9EABYOXQKNPNiE9NR");
        Rating r1 = new Rating("243", 5);
        s1.addRating(r1);
        Song s2 = new Song("Flashing Lights", "Kanye West", "5TRPicyLGbAF2LGBFbHGvO");
        Rating r2 = new Rating("40", 5);
        s2.addRating(r2);
        Rating r3 = new Rating("38", 2);
        s2.addRating(r3);
        Rating r4 = new Rating("223", 3);
        s2.addRating(r4);

        ArrayList<String> arr1 = new ArrayList<>(Arrays.asList("Sylvester Stallone","Talia Shire"));
        Movie m1 = new Movie("Rocky III", arr1);
        Rating rm1 = new Rating("1", 2);
        m1.addRating(rm1);
        ArrayList<String> arr2 = new ArrayList<>(Arrays.asList("Jason Biggs", "Chris Klein", "Thomas Ian Nicholas"));
        Movie m2 = new Movie("American Pie", arr2);
        Rating rm2 = new Rating("1", 4);
        m2.addRating(rm2);

        String f1 = "data/songs3.csv";
        String f2 = "data/movies3.csv";
        String f3 = "data/movie_ratings3.csv";
        MediaLibrary mL = new MediaLibrary();
        mL.populateLibrary(f1, f2, f3);

        ArrayList<Ratable> expected = new ArrayList<>();
        expected.add(s1);
        expected.add(m2);
        expected.add(s2);
        expected.add(m1);

        ArrayList<Ratable> actual = mL.topKRatables(100);

        assertTrue(compareRatableArrayLists(expected, actual));

    }

    @Test
    public void testTopKRatablesWithLess() {
        Song s1 = new Song("Ric Flair Drip (with Metro Boomin)", "Offset", "7sO5G9EABYOXQKNPNiE9NR");
        Rating r1 = new Rating("243", 5);
        s1.addRating(r1);
        Song s2 = new Song("Flashing Lights", "Kanye West", "5TRPicyLGbAF2LGBFbHGvO");
        Rating r2 = new Rating("40", 5);
        s2.addRating(r2);
        Rating r3 = new Rating("38", 2);
        s2.addRating(r3);
        Rating r4 = new Rating("223", 3);
        s2.addRating(r4);

        ArrayList<String> arr1 = new ArrayList<>(Arrays.asList("Sylvester Stallone","Talia Shire"));
        Movie m1 = new Movie("Rocky III", arr1);
        Rating rm1 = new Rating("1", 2);
        m1.addRating(rm1);
        ArrayList<String> arr2 = new ArrayList<>(Arrays.asList("Jason Biggs", "Chris Klein", "Thomas Ian Nicholas"));
        Movie m2 = new Movie("American Pie", arr2);
        Rating rm2 = new Rating("1", 4);
        m2.addRating(rm2);

        String f1 = "data/songs3.csv";
        String f2 = "data/movies3.csv";
        String f3 = "data/movie_ratings3.csv";
        MediaLibrary mL = new MediaLibrary();
        mL.populateLibrary(f1, f2, f3);

        ArrayList<Ratable> expected = new ArrayList<>();
        expected.add(s1);
        //expected.add(m2);
        //expected.add(s2);
        //expected.add(m1);

        ArrayList<Ratable> actual = mL.topKRatables(1);

        assertTrue(compareRatableArrayLists(expected, actual));

    }
}
