package ratings;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FileReader {

    public static ArrayList<String> readFile(String filename){
        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    public static ArrayList<Song> readSongs(String filename) {
        ArrayList<String> lines = readFile(filename);
        //ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
        ArrayList<Song> s1 = new ArrayList<>();
        for (String l : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(l.split(",")));
            String songID = splits.get(0);
            String artist = splits.get(1);
            String title = splits.get(2);
            String ReviewerID = splits.get(3);
            int rating = Integer.parseInt(splits.get(4));
            Song s = new Song(title, artist, songID);
            Rating r = new Rating(ReviewerID, rating);
            boolean flag = true;
            for (Song song : s1) {
                if (song.getTitle().equals(s.getTitle())) {
                    flag = false;
                    song.addRating(r);
                    break;
                }
            }
            if (flag) {
                s.addRating(r);
                s1.add(s);
            }
        }
        return s1;
    }

    public static ArrayList<Movie> readMovies(String filename) {
        ArrayList<String> lines = readFile(filename);
        ArrayList<Movie> m1 = new ArrayList<>();
        for (String l : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(l.split(",")));
            //movieTitle,castMember0,castMember1,castMember2,etc.
            String MovieTitle = splits.get(0);
            splits.remove(0);
            Movie m = new Movie(MovieTitle, splits);
            m1.add(m);
            }
        return m1;
    }
    public static ArrayList<Movie> readMovieRatings(ArrayList<Movie> m1, String filename) {
        ArrayList<String> lines = readFile(filename);
        ArrayList<Movie> m2 = new ArrayList<>();
        for (String l : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(l.split(",")));
            //movieTitle,castMember0,castMember1,castMember2,etc.
            String title = splits.get(0);
            String ReviewerID = splits.get(1);
            int rating = Integer.parseInt(splits.get(2));
            //splits.remove(0);
           for (Movie m : m1) {
               if (m.getTitle().equals(title)) {
                   boolean flag = false;
                   for (Movie mov : m2) {
                       if (mov.getTitle().equals(title)) {
                           Rating r1 = new Rating(ReviewerID, rating);
                           mov.addRating(r1);
                           flag = true;
                       }
                   }
                   if (!flag) {
                       Rating r2 = new Rating(ReviewerID, rating);
                       Movie mov = new Movie(title, m.getCast());
                       mov.addRating(r2);
                       m2.add(mov);

                   }
               }
           }

        }
        return m2;
    }
}
