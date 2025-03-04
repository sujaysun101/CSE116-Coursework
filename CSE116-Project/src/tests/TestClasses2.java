package tests;

import org.junit.Test;
import ratings.Movie;
import ratings.Rating;
import ratings.Song;
import ratings.datastructures.LinkedListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClasses2 {
    public boolean compareArrayListsIgnoreCase(ArrayList<String> arr1, ArrayList<String> arr2) {
        if (arr1.size() != arr2.size()) {
            return false;
        }
        else {
            boolean flag = true;
            for (int i = arr1.size() - 1; i >= 0; i--) {
                if (arr1.get(i).equalsIgnoreCase(arr2.get(i))) {
                }
                else {
                    flag = false;
                }
        }
        //return false;
        return flag;
    }
}
    //testGetCase
    @Test
    public void testGetCast() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("a");
        cast.add("b");
        cast.add("c");
        Movie m1 = new Movie("title", cast);
        ArrayList<String> computed = m1.getCast();
        assertTrue(compareArrayListsIgnoreCase(computed, cast));
    }

    @Test
    public void testGetCastMoreThanOneName() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("a a");
        cast.add("b");
        cast.add("c");
        cast.add("c");
        cast.add("a");
        Movie m1 = new Movie("title", cast);
        ArrayList<String> computed = m1.getCast();
        assertTrue(compareArrayListsIgnoreCase(computed, cast));
    }

    //testBayesianAverageRating
    @Test
    public void testBayesianAverageRatingMovie() {
        Song s1 = new Song("Taylor Swift", "Shake it off", "3");
        Rating r1 = new Rating("3", 1);
        Rating r2 = new Rating("4", 2);
        Rating r3 = new Rating("5", 3);

        ArrayList<String> cast = new ArrayList<>();
        cast.add("a");
        cast.add("b");
        cast.add("c");
        ArrayList<String> cast2 = new ArrayList<>();
        Movie m1 = new Movie("title", cast);
        cast.add("A");
        cast.add("b");
        cast.add("C");
        m1.addRating(r1);
        m1.addRating(r2);
        m1.addRating(r3);
        //double comp = m1.bayesianAverageRating(2, 3);
        assertEquals(2.4, m1.bayesianAverageRating(2, 3), 0.001);
    }

    @Test
    public void testBayesianAverageRatingMovieNoFakeRatings() {
        Song s1 = new Song("Taylor Swift", "Shake it off", "3");
        Rating r1 = new Rating("3", 1);
        Rating r2 = new Rating("4", 2);
        Rating r3 = new Rating("5", 3);

        ArrayList<String> cast = new ArrayList<>();
        cast.add("a");
        cast.add("b");
        cast.add("c");
        ArrayList<String> cast2 = new ArrayList<>();
        Movie m1 = new Movie("title", cast);
        cast.add("A");
        cast.add("b");
        cast.add("C");
        m1.addRating(r1);
        m1.addRating(r2);
        m1.addRating(r3);
        //double comp = m1.bayesianAverageRating(2, 3);
        assertEquals(2.0, m1.bayesianAverageRating(0, 3), 0.001);
    }

    @Test
    public void testBayesianAverageRatingNoRealOrFakeRatings() {
        Song s1 = new Song("Taylor Swift", "Shake it off", "3");
        //Rating r1 = new Rating("3", -1);
        //Rating r2 = new Rating("4", 10);
        //Rating r3 = new Rating("5", 6);

        ArrayList<String> cast = new ArrayList<>();
        cast.add("a");
        cast.add("b");
        cast.add("c");
        ArrayList<String> cast2 = new ArrayList<>();
        Movie m1 = new Movie("title", cast);
        cast.add("A");
        cast.add("b");
        cast.add("C");
        //m1.addRating(r1);
        //m1.addRating(r2);
        //m1.addRating(r3);
        //double comp = m1.bayesianAverageRating(2, 3);
        assertEquals(0.0, m1.bayesianAverageRating(0, 10), 0.001);

        assertEquals(3.0, m1.bayesianAverageRating(2, 3), 0.001);
    }

    @Test
    public void testBayesianAverageRatingMovieNoValidRatings() {
        Song s1 = new Song("Taylor Swift", "Shake it off", "3");
        Rating r1 = new Rating("3", -1);
        Rating r2 = new Rating("4", 10);
        Rating r3 = new Rating("5", 6);

        ArrayList<String> cast = new ArrayList<>();
        cast.add("a");
        cast.add("b");
        cast.add("c");
        ArrayList<String> cast2 = new ArrayList<>();
        Movie m1 = new Movie("title", cast);
        cast.add("A");
        cast.add("b");
        cast.add("C");
        m1.addRating(r1);
        m1.addRating(r2);
        m1.addRating(r3);
        //double comp = m1.bayesianAverageRating(2, 3);
        assertEquals(0.0, m1.bayesianAverageRating(2, 10), 0.001);
        assertEquals(0.0, m1.bayesianAverageRating(0, 0), 0.001);
        assertEquals(0.0, m1.bayesianAverageRating(0, 4), 0.001);
        assertEquals(3.0, m1.bayesianAverageRating(2, 3), 0.001);
    }

    @Test
    public void testBayesianAverageRatingMovieWithOneInvalidRating() {
        Song s1 = new Song("Taylor Swift", "Shake it off", "3");
        Rating r1 = new Rating("3", 1);
        Rating r2 = new Rating("4", 2);
        Rating r3 = new Rating("5", 3);

        ArrayList<String> cast = new ArrayList<>();
        cast.add("a");
        cast.add("b");
        cast.add("c");
        ArrayList<String> cast2 = new ArrayList<>();
        Movie m1 = new Movie("title", cast);
        cast.add("A");
        cast.add("b");
        cast.add("C");
        m1.addRating(r1);
        m1.addRating(r2);
        m1.addRating(r3);
        //double comp = m1.bayesianAverageRating(2, 3);
        assertEquals(0.0, m1.bayesianAverageRating(2, -3), 0.001);
    }
}
