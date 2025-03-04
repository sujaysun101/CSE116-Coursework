package tests;

import org.junit.Test;
import ratings.FileReader;
import ratings.Movie;
import ratings.Rating;
import ratings.Song;
import tests.TestDataStructures2;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static ratings.FileReader.readSongs;

public class TestFiles {
    public boolean compareMovieArrayLists(ArrayList<Movie> i, ArrayList<Movie> j) {
        TestDataStructures2 tDS2 = new TestDataStructures2();
//        if (i.isEmpty() && j.isEmpty()) {
//            return true;
//        }
//        if (i.isEmpty() || j.isEmpty()) {
//            return false;
//        }
        if (i.size() != j.size()) {
            return false;
        }
        for (int x = 0; x <= i.size() - 1; x++) {
            boolean flag = false;
            for (int y = 0; y <= j.size() - 1; y++) {
                if (i.get(x).getTitle().equals(j.get(y).getTitle()) && i.get(x).getCast().equals(j.get(y).getCast()) && tDS2.compareListsOfRatings(i.get(x).getRatings(), j.get(y).getRatings())) {
                    flag = true;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    public boolean compareSongArrayLists(ArrayList<Song> i, ArrayList<Song> j) {
        TestDataStructures2 tDS2 = new TestDataStructures2();
        if (i.size() != j.size()) {
            return false;
        }
        for (int x = 0; x <= i.size() - 1; x++) {
            boolean flag = false;
            for (int y = 0; y <= j.size() - 1; y++) {
                if (i.get(x).getTitle().equals(j.get(y).getTitle()) && i.get(x).getArtist().equals(j.get(y).getArtist()) && tDS2.compareListsOfRatings(i.get(x).getRatings(), j.get(y).getRatings()) && i.get(x).getSongID().equals(j.get(y).getSongID())) {
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
    public void testReadSongs() {
        String filename = "data/sample_songs.csv";
        Song s1 = new Song("Nightcore", "Ken Carson", "6p1j9OP2IBdzR5tgtyJk10");
        Rating r1 = new Rating("221", 5);
        s1.addRating(r1);
        Song s2 = new Song("Ric Flair Drip (with Metro Boomin)", "Offset", "7sO5G9EABYOXQKNPNiE9NR");
        Rating r2 = new Rating("243", 5);
        s2.addRating(r2);
        Song s3 = new Song("Flashing Lights", "Kanye West", "5TRPicyLGbAF2LGBFbHGvO");
        Rating r3 = new Rating("40", 5);
        s3.addRating(r3);
        //Song s4 = new Song("Flashing Lights", "Kanye West", "5TRPicyLGbAF2LGBFbHGvO");
        Rating r4 = new Rating("38", 2);
        s3.addRating(r4);
        //Song s5 = new Song("Flashing Lights", "Kanye West", "5TRPicyLGbAF2LGBFbHGvO");
        Rating r5 = new Rating("223", 3);
        s3.addRating(r5);

        ArrayList<Song> expected = new ArrayList<>();
        expected.add(0, s1);
        expected.add(1, s2);
        expected.add(2, s3);
        //expected.add(3, s4);
        //expected.add(4, s5);

        ArrayList<Song> actual = FileReader.readSongs(filename);

        assertTrue(compareSongArrayLists(expected, actual));

    }

    @Test
    public void testReadSongsWithInvalidFileName() {
        String filename = "data/song.csv";

        ArrayList<Song> expected = new ArrayList<>();

        ArrayList<Song> actual = FileReader.readSongs(filename);

        assertEquals(expected, actual);

    }

    @Test
    public void testReadMovies() {
        String filename = "data/samplemovies.csv";
        ArrayList<String> arr1 = new ArrayList<>(Arrays.asList("Sylvester Stallone","Talia Shire"));
        Movie m1 = new Movie("Rocky III", arr1);
        ArrayList<String> arr2 = new ArrayList<>(Arrays.asList("Jason Biggs", "Chris Klein", "Thomas Ian Nicholas"));
        Movie m2 = new Movie("American Pie", arr2);
        ArrayList<String> arr3 = new ArrayList<>(Arrays.asList("Kevin Smith"));
        Movie m3 = new Movie("Jay and Silent Bob Strike Back", arr3);

        ArrayList<Movie> expected = new ArrayList<>();
        expected.add(0, m1);
        expected.add(1, m2);
        expected.add(2, m3);

        ArrayList<Movie> actual = FileReader.readMovies(filename);

        assertTrue(compareMovieArrayLists(expected, actual));

    }

    @Test
    public void testReadMoviesWithInvalidFileName() {
        String filename = "data/movie.csv";

        ArrayList<Movie> expected = new ArrayList<>();

        ArrayList<Movie> actual = FileReader.readMovies(filename);

        assertEquals(expected, actual);
    }

        @Test
    public void testReadMovieRatings() {
        String filename = "data/sample_movie_ratings.csv";
        ArrayList<String> arr1 = new ArrayList<>(Arrays.asList("Sylvester Stallone","Talia Shire"));
        Movie m1 = new Movie("Rocky III", arr1);
        Rating r1 = new Rating("1", 2);
        m1.addRating(r1);
        ArrayList<String> arr2 = new ArrayList<>(Arrays.asList("Jason Biggs", "Chris Klein", "Thomas Ian Nicholas"));
        Movie m2 = new Movie("American Pie", arr2);
        Rating r2 = new Rating("1", 4);
        m2.addRating(r2);
        ArrayList<String> arr3 = new ArrayList<>(Arrays.asList("Kevin Smith"));
        Movie m3 = new Movie("Jay and Silent Bob Strike Back", arr3);
        Rating r3 = new Rating("1", 2);
        m3.addRating(r3);

        ArrayList<Movie> expected = new ArrayList<>();
        expected.add(0, m1);
        expected.add(1, m2);
        expected.add(2, m3);

        ArrayList<Movie> mov = FileReader.readMovies("data/samplemovies.csv");
        ArrayList<Movie> actual = FileReader.readMovieRatings(mov, filename);

        assertTrue(compareMovieArrayLists(expected, actual));

    }

    @Test
    public void testReadMovieRatingsWithInvalidFileName() {
        String filename = "data/movie_rating.csv";

        ArrayList<Movie> expected = new ArrayList<>();

        ArrayList<Movie> mov = FileReader.readMovies("data/movie.csv");
        assertEquals(mov, expected);

        ArrayList<Movie> actual = FileReader.readMovieRatings(mov, filename);

        assertEquals(expected, actual);
    }


    @Test
    public void testReadMovieRatingsWithMultipleRatings() {
        String filename = "data/movie_ratings2.csv";
        ArrayList<String> arr1 = new ArrayList<>(Arrays.asList("Sylvester Stallone","Talia Shire"));
        Movie m1 = new Movie("Rocky III", arr1);
        Rating r1 = new Rating("1", 2);
        m1.addRating(r1);
        ArrayList<String> arr2 = new ArrayList<>(Arrays.asList("Jason Biggs", "Chris Klein", "Thomas Ian Nicholas"));
        Movie m2 = new Movie("American Pie", arr2);
        Rating r2 = new Rating("1", 4);
        m2.addRating(r2);
        ArrayList<String> arr3 = new ArrayList<>(Arrays.asList("Kevin Smith"));
        Movie m3 = new Movie("Jay and Silent Bob Strike Back", arr3);
        Rating r3 = new Rating("1", 2);
        m3.addRating(r3);
        Rating r4 = new Rating("1", 2);
        m3.addRating(r4);
        Rating r5 = new Rating("1", 3);
        m3.addRating(r5);


        ArrayList<Movie> expected = new ArrayList<>();
        expected.add(0, m1);
        expected.add(1, m2);
        expected.add(2, m3);

        ArrayList<Movie> mov = FileReader.readMovies("data/samplemovies.csv");
        ArrayList<Movie> actual = FileReader.readMovieRatings(mov, filename);

        assertTrue(compareMovieArrayLists(expected, actual));

    }
}
