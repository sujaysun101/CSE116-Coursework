package tests;

import org.junit.Test;
import ratings.Song;
import ratings.Reviewer;
import ratings.Rating;

import static org.junit.Assert.*;

public class TestClasses1 {
    public boolean compareSongs(Song s1, Song s2) {
        if (s1.getTitle().equals(s2.getTitle()) && s1.getArtist().equals(s2.getArtist()) && s1.getSongID().equals(s2.getSongID())) {
            return true;
        }
    return false;
    }
    public boolean compareRatings(Rating r1, Rating r2) {
        if (r1.getReviewerID().equals(r2.getReviewerID()) && r1.getRating() == r2.getRating()) {
            return true;
        }
        return false;
    }
    public boolean compareReviewers(Reviewer re1, Reviewer re2) {
        if (re1.getReviewerID().equals(re2.getReviewerID())) {
            return true;
        }
        return false;
    }
    @Test
    public void testCompareSongs() {
        Song s = new Song("Shake it off", "Taylor swift", "3");
        Song s2 = new Song("Theres nothing holding me back", "Shawn mendez", "4");

        assertEquals(false, compareSongs(s, s2));

    }
    @Test
    public void testEmptyID() {
        Song s = new Song("Shake it off", "Taylor swift", "3");

        assertTrue(s.getSongID().equals("3"));
    }
    @Test
    public void testEmptyTitle() {
        Song s = new Song("Shake it off", "Taylor swift", "3");

        assertTrue(s.getTitle().equals("Shake it off"));
    }
    @Test
    public void testEmptyArtist() {
        Song s = new Song("Shake it off", "Taylor swift", "3");

        assertTrue(s.getArtist().equals("Taylor swift"));
    }
    @Test
    public void testSongTitle() {
        Song s = new Song("Shake it off", "Taylor swift", "3");
        Song s2 = new Song("Theres nothing hold me back", "Taylor swift", "3");

        assertFalse(s.getTitle().equals(s2.getTitle()));
    }

    @Test
    public void testSongArtist() {
        Song s = new Song("Shake it off", "Taylor swift", "3");
        Song s2 = new Song("Shake it off", "shawn mendes", "3");

        assertFalse(s.getArtist().equals(s2.getArtist()));
    }
    @Test
    public void testSongID() {
        Song s = new Song("Shake it off", "Taylor swift", "3");
        Song s2 = new Song("Shake it off", "Taylor swift", "4");

        assertFalse(s.getSongID().equals(s2.getSongID()));
    }

    @Test
    public void testSongIDSetter() {
        Song s = new Song("Shake it off", "Taylor swift", "3");

        s.setSongID("4");
        assertTrue(s.getSongID().equals("4"));
    }
    @Test
    public void testSongArtistSetter() {
        Song s = new Song("Shake it off", "Taylor swift", "3");

        s.setArtist("Shawn mendes");
        assertTrue(s.getArtist().equals("Shawn mendes"));
    }
    @Test
    public void testSongTitleSetter() {
        Song s = new Song("Shake it off", "Taylor swift", "3");

        s.setTitle("Theres nothing holding me back");
        assertTrue(s.getTitle().equals("Theres nothing holding me back"));
    }

    //Reviewers

    @Test
    public void testCompareReviewers() {
        Reviewer re = new Reviewer("3");
        Reviewer re2 = new Reviewer("3");

        assertEquals(true, compareReviewers(re, re2));

    }
    @Test
    public void testEmptyReID() {
        Reviewer re = new Reviewer("3");

        assertTrue(re.getReviewerID().equals("3"));
    }
    @Test
    public void testReviewerID() {
        Reviewer re = new Reviewer("3");
        Reviewer re2 = new Reviewer("2");

        assertFalse(re.getReviewerID().equals(re2.getReviewerID()));
    }
    @Test
    public void testReviewerIDSetter() {
        Reviewer re = new Reviewer("3");

        re.setReviewerID("4");
        assertTrue(re.getReviewerID().equals("4"));
    }
    @Test
    public void testRateSong() {
        Reviewer re = new Reviewer("3");
        Reviewer re1 = new Reviewer("3");
        Reviewer re2 = new Reviewer("3");
        Reviewer re3 = new Reviewer("3");
        Reviewer re4 = new Reviewer("3");
        Reviewer re5 = new Reviewer("3");
        Reviewer re6 = new Reviewer("3");
        Reviewer re7 = new Reviewer("3");
        Reviewer re8 = new Reviewer("3");
        Reviewer re9 = new Reviewer("3");
        Reviewer re10 = new Reviewer("3");
        Reviewer re11 = new Reviewer("3");
        Reviewer re12 = new Reviewer("3");
        Reviewer re13 = new Reviewer("3");
        Reviewer re14 = new Reviewer("3");
        Reviewer re15 = new Reviewer("3");
        Reviewer re16 = new Reviewer("3");
        Reviewer re17 = new Reviewer("3");

        Rating fella = re.rateSong(1);
        assertTrue(fella.getRating() == 1);
        assertTrue(re.getReviewerID().equals(fella.getReviewerID()));
        assertTrue(re1.rateSong(2).getRating() == 2);
        assertTrue(re2.rateSong(3).getRating() == 3);
        assertTrue(re3.rateSong(4).getRating() == 4);
        assertTrue(re4.rateSong(5).getRating() == 5);
        assertTrue(re5.rateSong(6).getRating() == -1);
        assertTrue(re6.rateSong(-1).getRating() == -1);
        assertTrue(re7.rateSong(-100000).getRating() == -1);
        assertTrue(re7.rateSong(0).getRating() == -1);
        assertTrue(re8.rateSong(-3005).getRating() == -1);
        assertTrue(re9.rateSong(-85).getRating() == -1);
        assertTrue(re10.rateSong(-5).getRating() == -1);
        assertTrue(re11.rateSong(9).getRating() == -1);
        assertTrue(re12.rateSong(23).getRating() == -1);
        assertTrue(re13.rateSong(34).getRating() == -1);
        assertTrue(re14.rateSong(845).getRating() == -1);
        assertTrue(re15.rateSong(796).getRating() == -1);
        assertTrue(re16.rateSong(5000).getRating() == -1);
        assertTrue(re17.rateSong(100).getRating() == -1);

    }
    @Test
    public void testInvalidRateSong() {
        Reviewer re = new Reviewer("3");

        assertTrue(re.rateSong(6).getRating() == -1);
    }


    //Ratings

    @Test
    public void testCompareRatings() {
        Rating r = new Rating("3", 3);
        Rating r2 = new Rating("3",2);

        assertFalse(compareRatings(r, r2));

    }
    @Test
    public void testEmptyRID() {
        Rating r = new Rating("3", 3);

        assertTrue(r.getReviewerID().equals("3"));
    }
    @Test
    public void testEmptyRating() {
        Rating r = new Rating("3", 3);

        assertTrue(r.getRating() == 3);
    }
    @Test
    public void testRatingID() {
        Rating r = new Rating("3", 3);
        Rating r2 = new Rating("2", 3);

        assertFalse(r.getReviewerID().equals(r2.getReviewerID()));
    }
    @Test
    public void testRatingRatings() {
        Rating r = new Rating("3", 3);
        Rating r2 = new Rating("3", 2);

        assertFalse(r.getRating() == r2.getRating());
    }
    @Test
    public void testRatingIDSetter() {
        Rating r = new Rating("3", 3);

        r.setReviewerID("4");
        assertTrue(r.getReviewerID().equals("4"));
    }
    @Test
    public void testRatingRSetter() {
        Rating r = new Rating("3", 3);

        r.setRating(4);
        assertTrue(r.getRating() == 4);
    }
    @Test
    public void testInvalidRatings() {
        Rating r = new Rating("3", 6);

        assertTrue(r.getRating() == -1);
    }
    @Test
    public void testInvalidUsingSetRatings() {
        Rating r = new Rating("3", 3);

        r.setRating(6);
        assertTrue(r.getRating() == -1);
    }
    @Test
    public void testInvalidUsingConstructor() {
        Rating r = new Rating("3", 3);

        r.setRating(6);
        assertFalse(r.getRating() <= 5 && r.getRating() >= 1);
    }
}
