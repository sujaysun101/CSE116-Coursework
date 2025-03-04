package tests;

import org.junit.Before;
import org.junit.Test;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;
import ratings.datastructures.LinkedListNode;

import static org.junit.Assert.*;

public class TestDataStructures1 {
    public boolean compareListsOfRatings(LinkedListNode<Rating> r1, LinkedListNode<Rating> r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if ((r1 == null && r2 != null) || (r1 != null && r2 == null)) {
            return false;
        }
        while (r1 != null && r2 != null) {
            assertEquals(r1.getValue().getRating(), r2.getValue().getRating());
            assertEquals(r1.getValue().getReviewerID(), r2.getValue().getReviewerID());
            if (r1.getNext() == null && r2.getNext() == null) {
                return true;
            }
            else if (r1.getNext() == null || r2.getNext() == null) {
                return false;
            }
            r1 = r1.getNext();
            r2 = r2.getNext();
        }
        return true;
    }

    //addRating
    /*@Test
    public void testAddRating() {

        Song s1 = new Song("Taylor Swift", "Shake it off", "3");
        Rating r1 = new Rating("3", 1);
        Rating r2 = new Rating("4", 2);

        assertEquals(3.0, s1.addRating(r1));

        assertTrue(compareListsOfRatings(n7, s1.getRatings()));


    }*/

    //averageRating

    @Test
    public void testAverageRating() {

        Song s1 = new Song("Taylor Swift", "Shake it off", "3");
        Rating r1 = new Rating("3", 1);
        Rating r2 = new Rating("4", 2);
        Rating r3 = new Rating("5", 3);
        Rating r4 = new Rating("6", 4);
        Rating r5 = new Rating("7", 5);
        Rating r6 = new Rating("8", 6);
        Rating r7 = new Rating("9", 7);

        s1.addRating(r1);
        s1.addRating(r2);
        s1.addRating(r3);
        s1.addRating(r4);
        s1.addRating(r5);
        s1.addRating(r6);
        s1.addRating(r7);

        assertEquals(3.0, s1.averageRating(), 0.001);


        LinkedListNode<Rating> n1 = new LinkedListNode<>(r7, null);
        LinkedListNode<Rating> n2 = new LinkedListNode<>(r6, n1);
        LinkedListNode<Rating> n3 = new LinkedListNode<>(r5, n2);
        LinkedListNode<Rating> n4 = new LinkedListNode<>(r4, n3);
        LinkedListNode<Rating> n5 = new LinkedListNode<>(r3, n4);
        LinkedListNode<Rating> n6 = new LinkedListNode<>(r2, n5);
        LinkedListNode<Rating> n7 = new LinkedListNode<>(r1, n6);

        assertTrue(compareListsOfRatings(n7, s1.getRatings()));


    }

    @Test
    public void testAverageRatingWithNoRatings() {

        Song s1 = new Song("Taylor Swift", "Shake it off", "3");

        assertEquals(0.0, s1.averageRating(), 0.001);


        LinkedListNode<Rating> n1 = null;

        assertTrue(compareListsOfRatings(n1, s1.getRatings()));


    }

    @Test
    public void testAverageRatingWithNegativeOne() {

        Song s1 = new Song("Taylor Swift", "Shake it off", "3");
        Rating r1 = new Rating("3", -1);
        Rating r2 = new Rating("4", -1);
        Rating r3 = new Rating("5", -1);
        Rating r4 = new Rating("6", -1);
        Rating r5 = new Rating("7", -1);
        Rating r6 = new Rating("8", -1);
        Rating r7 = new Rating("9", -1);

        s1.addRating(r1);
        s1.addRating(r2);
        s1.addRating(r3);
        s1.addRating(r4);
        s1.addRating(r5);
        s1.addRating(r6);
        s1.addRating(r7);

        assertEquals(0.0, s1.averageRating(), 0.001);


        LinkedListNode<Rating> n1 = new LinkedListNode<>(r7, null);
        LinkedListNode<Rating> n2 = new LinkedListNode<>(r6, n1);
        LinkedListNode<Rating> n3 = new LinkedListNode<>(r5, n2);
        LinkedListNode<Rating> n4 = new LinkedListNode<>(r4, n3);
        LinkedListNode<Rating> n5 = new LinkedListNode<>(r3, n4);
        LinkedListNode<Rating> n6 = new LinkedListNode<>(r2, n5);
        LinkedListNode<Rating> n7 = new LinkedListNode<>(r1, n6);

        assertTrue(compareListsOfRatings(n7, s1.getRatings()));

    }

    @Test
    public void testAverageRatingWithDecimalResult() {

        Song s1 = new Song("Taylor Swift", "Shake it off", "3");
        Rating r1 = new Rating("3", 1);
        Rating r2 = new Rating("4", 1);
        Rating r3 = new Rating("5", 3);

        s1.addRating(r1);
        s1.addRating(r2);
        s1.addRating(r3);

        assertEquals(1.666, s1.averageRating(), 0.001);


        LinkedListNode<Rating> n1 = new LinkedListNode<>(r3, null);
        LinkedListNode<Rating> n2 = new LinkedListNode<>(r2, n1);
        LinkedListNode<Rating> n3 = new LinkedListNode<>(r1, n2);

        assertTrue(compareListsOfRatings(n3, s1.getRatings()));


    }


    //removeRatingByReviewer
    /*@Test
    public void testRemoveRatingByReviewer() {
        Song s1 = new Song("T", "A", "ID");
        Rating r1 = new Rating("3", 1);
        Rating r2 = new Rating("4", 2);
        Rating r3 = new Rating("5", 3);
        Rating r4 = new Rating("6", 4);
        Rating r5 = new Rating("7", 5);
        Rating r6 = new Rating("8", -1);
        Rating r7 = new Rating("9", 100);

        s1.addRating(r1);
        s1.addRating(r2);
        s1.addRating(r3);
        s1.addRating(r4);
        s1.addRating(r5);
        s1.addRating(r6);
        s1.addRating(r7);

        s1.removeRatingByReviewer(new Reviewer("4"));

        LinkedListNode<Rating> n7 = new LinkedListNode<>(r7, null);
        //LinkedListNode<Rating> n6 = new LinkedListNode<>(r7, n7);
        LinkedListNode<Rating> n5 = new LinkedListNode<>(r6, n7);
        LinkedListNode<Rating> n4 = new LinkedListNode<>(r5, n5);
        LinkedListNode<Rating> n3 = new LinkedListNode<>(r4, n4);
        LinkedListNode<Rating> n2 = new LinkedListNode<>(r3, n3);
        LinkedListNode<Rating> n1 = new LinkedListNode<>(r1, n2);

        assertFalse(compareListsOfRatings(n1, s1.getRatings()));
    }*/

    @Test
    public void testRemoveRatingByReviewer() {
        Song s1 = new Song("T", "A", "ID");
        Rating r1 = new Rating("3", 1);
        Rating r2 = new Rating("4", 2);
        Rating r3 = new Rating("5", 3);
        Rating r4 = new Rating("6", 4);
        Rating r5 = new Rating("7", 5);
        Rating r6 = new Rating("8", -1);
        Rating r7 = new Rating("9", 100);

        s1.addRating(r1);
        s1.addRating(r2);
        s1.addRating(r3);
        s1.addRating(r4);
        s1.addRating(r5);
        s1.addRating(r6);
        s1.addRating(r7);

        s1.removeRatingByReviewer(new Reviewer("4"));

        LinkedListNode<Rating> n7 = new LinkedListNode<>(r7, null);
        LinkedListNode<Rating> n6 = new LinkedListNode<>(r6, n7);
        LinkedListNode<Rating> n5 = new LinkedListNode<>(r5, n6);
        LinkedListNode<Rating> n4 = new LinkedListNode<>(r4, n5);
        LinkedListNode<Rating> n3 = new LinkedListNode<>(r3, n4);
        //LinkedListNode<Rating> n2 = new LinkedListNode<>(r2, n3);
        LinkedListNode<Rating> n1 = new LinkedListNode<>(r1, n3);


        assertTrue(compareListsOfRatings(n1, s1.getRatings()));
    }

    @Test
    public void testRemoveRatingByReviewerTailNode() {
        Song s1 = new Song("T", "A", "ID");
        Rating r1 = new Rating("3", 1);
        Rating r2 = new Rating("4", 2);
        Rating r3 = new Rating("5", 3);
        Rating r4 = new Rating("6", 4);
        Rating r5 = new Rating("7", 5);
        Rating r6 = new Rating("8", -1);
        Rating r7 = new Rating("9", 100);

        s1.addRating(r1);
        s1.addRating(r2);
        s1.addRating(r3);
        s1.addRating(r4);
        s1.addRating(r5);
        s1.addRating(r6);
        s1.addRating(r7);

        s1.removeRatingByReviewer(new Reviewer("9"));

        //LinkedListNode<Rating> n7 = new LinkedListNode<>(r7, null);
        LinkedListNode<Rating> n6 = new LinkedListNode<>(r6, null);
        LinkedListNode<Rating> n5 = new LinkedListNode<>(r5, n6);
        LinkedListNode<Rating> n4 = new LinkedListNode<>(r4, n5);
        LinkedListNode<Rating> n3 = new LinkedListNode<>(r3, n4);
        LinkedListNode<Rating> n2 = new LinkedListNode<>(r2, n3);
        LinkedListNode<Rating> n1 = new LinkedListNode<>(r1, n2);


        assertTrue(compareListsOfRatings(n1, s1.getRatings()));
    }

    @Test
    public void testRemoveRatingByReviewerHeadNode() {
        Song s1 = new Song("T", "A", "ID");
        Rating r1 = new Rating("3", 1);
        Rating r2 = new Rating("4", 2);
        Rating r3 = new Rating("5", 3);
        Rating r4 = new Rating("6", 4);
        Rating r5 = new Rating("7", 5);
        Rating r6 = new Rating("8", -1);
        Rating r7 = new Rating("9", 100);

        s1.addRating(r1);
        s1.addRating(r2);
        s1.addRating(r3);
        s1.addRating(r4);
        s1.addRating(r5);
        s1.addRating(r6);
        s1.addRating(r7);

        s1.removeRatingByReviewer(new Reviewer("3"));

        LinkedListNode<Rating> n7 = new LinkedListNode<>(r7, null);
        LinkedListNode<Rating> n6 = new LinkedListNode<>(r6, n7);
        LinkedListNode<Rating> n5 = new LinkedListNode<>(r5, n6);
        LinkedListNode<Rating> n4 = new LinkedListNode<>(r4, n5);
        LinkedListNode<Rating> n3 = new LinkedListNode<>(r3, n4);
        LinkedListNode<Rating> n2 = new LinkedListNode<>(r2, n3);
        //LinkedListNode<Rating> n1 = new LinkedListNode<>(r1, n2);


        assertTrue(compareListsOfRatings(n2, s1.getRatings()));
    }

}
