package ratings;

import ratings.FileReader;
import ratings.datastructures.SongBayesianRatingComparator;

import java.util.ArrayList;
import java.util.Comparator;

public class MediaLibrary {
    private ArrayList<Ratable> rats;
    public MediaLibrary() {
        this.rats = new ArrayList<>();
    }
    public void populateLibrary(String fileSongsWithRatings, String fileMoviesTitleAndCast, String fileMovieRatings) {
        ArrayList<Song> songs = FileReader.readSongs(fileSongsWithRatings);
        for (Song s : songs) {
            boolean flag = false;
            for (Ratable rat : rats) {
                double currentRating = s.bayesianAverageRating(2, 3);
                if (currentRating > rat.bayesianAverageRating(2, 3)) {
                    flag = true;
                    rats.add(rats.indexOf(rat), s);
                    break;
                }
            }
            if (!flag) {
                rats.add(s);
            }
        }
        ArrayList<Movie> movies = FileReader.readMovies(fileMoviesTitleAndCast);
        ArrayList<Movie> movie_ratings = FileReader.readMovieRatings(movies, fileMovieRatings);
        for (Movie m : movie_ratings) {
            boolean flag = false;
            for (Ratable rat : rats) {
                double currentRating = m.bayesianAverageRating(2, 3);
                if (currentRating > rat.bayesianAverageRating(2, 3)) {
                    flag = true;
                    rats.add(rats.indexOf(rat), m);
                    break;
                }
            }
            if (!flag) {
                rats.add(m);
            }
        }
    }
    public ArrayList<Ratable> topKRatables(int k) {
        if (k >= rats.size()) {
            return rats;
        }
        else {
            ArrayList<Ratable> r = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                r.add(rats.get(i));
            }
            return r;
        }
    }
}




