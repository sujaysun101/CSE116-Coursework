package tests;

import org.junit.Test;
import ratings.DegreesOfSeparation;
import ratings.Movie;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestDataStructures3 {
    @Test
    public void test() {
        Movie m1 = new Movie("a", new ArrayList<>(Arrays.asList("a", "b", "c")));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(m1);
        DegreesOfSeparation dOS1 = new DegreesOfSeparation(movies);
        int newDOS = dOS1.degreesOfSeparation("b", "b");
        assertEquals(0, newDOS);
    }
    @Test
    public void test1() {
        Movie m1 = new Movie("a", new ArrayList<>(Arrays.asList("a", "b", "c")));
        Movie m2 = new Movie("b", new ArrayList<>(Arrays.asList("b", "c", "d")));
        Movie m3 = new Movie("c", new ArrayList<>(Arrays.asList("s")));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);
        DegreesOfSeparation dOS1 = new DegreesOfSeparation(movies);
        int newDOS = dOS1.degreesOfSeparation("b", "d");
        assertEquals(1, newDOS);
        int newDOS1 = dOS1.degreesOfSeparation("a", "d");
        assertEquals(2, newDOS1);
        int newDOS2 = dOS1.degreesOfSeparation("a", "z");
        assertEquals(-1, newDOS2);
        int newDOS3 = dOS1.degreesOfSeparation("a", "s");
        assertEquals(-1, newDOS3);
    }
    @Test
    public void test2() {
        Movie m1 = new Movie("a", new ArrayList<>(Arrays.asList("a", "b", "c")));
        Movie m2 = new Movie("b", new ArrayList<>(Arrays.asList("b", "c", "d")));
        Movie m3 = new Movie("c", new ArrayList<>(Arrays.asList("d", "e")));
        Movie m4 = new Movie("c", new ArrayList<>(Arrays.asList("e", "f")));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);
        movies.add(m4);
        DegreesOfSeparation dOS1 = new DegreesOfSeparation(movies);
        int newDOS = dOS1.degreesOfSeparation("a", "f");
        assertEquals(4, newDOS);

    }
    @Test
    public void test3() {
        Movie m1 = new Movie("a", new ArrayList<>(Arrays.asList("a", "b", "c")));
        Movie m2 = new Movie("b", new ArrayList<>(Arrays.asList("b", "c", "d")));
        Movie m3 = new Movie("c", new ArrayList<>(Arrays.asList("d", "e")));
        Movie m4 = new Movie("c", new ArrayList<>(Arrays.asList("e", "f")));
        Movie m5 = new Movie("c", new ArrayList<>(Arrays.asList("b", "f")));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);
        movies.add(m4);
        movies.add(m5);
        DegreesOfSeparation dOS1 = new DegreesOfSeparation(movies);
        int newDOS = dOS1.degreesOfSeparation("a", "f");
        assertEquals(2, newDOS);

    }
}
