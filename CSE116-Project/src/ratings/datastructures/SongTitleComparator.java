package ratings.datastructures;

import ratings.Song;

public class SongTitleComparator extends Comparator<Song> {
    @Override
    public boolean compare(Song s1, Song s2) {
        int s = s1.getTitle().compareToIgnoreCase(s2.getTitle());
        if (s < 0) {
            return true;
        }
        else {
            return false;
        }
    }
}

