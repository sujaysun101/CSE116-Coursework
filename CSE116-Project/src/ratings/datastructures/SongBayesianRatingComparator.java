package ratings.datastructures;

import ratings.Song;

public class SongBayesianRatingComparator extends Comparator<Song> {
    @Override
    public boolean compare(Song s1, Song s2) {
        double r1 = s1.bayesianAverageRating(2, 3);
        double r2 = s2.bayesianAverageRating(2, 3);
        if (r1 > r2) {
            return true;
        }
        else {
            return false;
        }
    }
}
