package tests;

import org.junit.Test;
import ratings.Playlist;
import ratings.Rating;
import ratings.Song;
import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class TestDataStructures2 {

    public boolean compareSongs(Song s1, Song s2) {
        if (s1.getTitle().equals(s2.getTitle()) && s1.getArtist().equals(s2.getArtist()) && s1.getSongID().equals(s2.getSongID())) {
            return true;
        }
        return false;
    }

   public boolean compareSongLists(LinkedListNode<Song> n1, LinkedListNode<Song> n2) {
       if (n1 == null && n2 == null) {
           return true;
       }
       if ((n1 == null && n2 != null) || (n1 != null && n2 == null)) {
           return false;
       }
       assertTrue(compareSongs(n1.getValue(), n2.getValue()));
        compareSongLists(n1.getNext(), n2.getNext());
        return true;
   }

    public void inOrderTraversal(BinaryTreeNode<Song> b1, BinaryTreeNode<Song> b2) {
        if (b1 == null && b2 == null) {
            assertTrue(true);
        }
        else if (b1 == null && b2 != null) {
            assertTrue(false);
        }
        else if (b1 != null && b2 == null) {
            assertTrue(false);
        }
        else {
            inOrderTraversal(b1.getLeft(), b2.getLeft());
            //assertTrue(compareSongTrees(b1, b2));
            assertTrue(compareSongs(b1.getValue(), b2.getValue()));
            assertTrue(compareListsOfRatings(b1.getValue().getRatings(), b2.getValue().getRatings()));
            //assertTrue(true);
            inOrderTraversal(b1.getRight(), b2.getRight());
        }
    }

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

    public boolean compareSongTrees(BinaryTreeNode<Song> b1, BinaryTreeNode<Song> b2) {
        inOrderTraversal(b1, b2);
        return true;
    }

    @Test
    public void testAddSong() {
        Playlist p = new Playlist(new SongTitleComparator());
        Song s1 = new Song("a", "b", "3");
        Song s2 = new Song("b", "c", "3");
        Song s3 = new Song("c", "c", "3");
        Song s4 = new Song("d", "b", "3");
        Song s5 = new Song("e", "c", "3");
        Song s6 = new Song("f", "b", "3");
        Song s7 = new Song("aa", "b", "3");
        p.addSong(s1);
        p.addSong(s2);
        p.addSong(s3);
        p.addSong(s4);
        p.addSong(s5);
        p.addSong(s6);
        p.addSong(s7);
        assertTrue(true);
    }

    @Test
    public void testGetSongList() {

        Song s1 = new Song("a", "b", "3");
        Song s7 = new Song("aa", "b", "3");
        Song s2 = new Song("b", "c", "3");
        Song s3 = new Song("c", "c", "3");
        Song s4 = new Song("d", "b", "3");
        Song s5 = new Song("e", "c", "3");
        Song s6 = new Song("f", "b", "3");

        LinkedListNode<Song> n7 = new LinkedListNode<>(s6, null);
        LinkedListNode<Song> n6 = new LinkedListNode<>(s5, n7);
        LinkedListNode<Song> n5 = new LinkedListNode<>(s4, n6);
        LinkedListNode<Song> n4 = new LinkedListNode<>(s3, n5);
        LinkedListNode<Song> n3 = new LinkedListNode<>(s2, n4);
        LinkedListNode<Song> n2 = new LinkedListNode<>(s7, n3);
        LinkedListNode<Song> n1 = new LinkedListNode<>(s1, n2);

        Playlist p = new Playlist(new SongTitleComparator());
        p.addSong(s1);
        p.addSong(s2);
        p.addSong(s3);
        p.addSong(s4);
        p.addSong(s5);
        p.addSong(s6);
        p.addSong(s7);

        assertTrue(compareSongLists(n1, p.getSongList()));
    }

    @Test
    public void testSizeofReturnSongList() {
        Song s1 = new Song("a", "b", "3");
        Song s2 = new Song("b", "b", "3");
        Song s3 = new Song("c", "b", "3");
        Song s4 = new Song("d", "b", "3");
        Song s5 = new Song("e", "b", "3");

        Playlist p = new Playlist(new SongTitleComparator());
        p.addSong(s1);
        p.addSong(s2);
        p.addSong(s3);
        p.addSong(s4);
        p.addSong(s5);

        LinkedListNode<Song> head = p.getSongList();
        int num = 0;
        LinkedListNode<Song> currentNode = head;
        while (currentNode != null) {
            num++;
            currentNode = currentNode.getNext();
        }


        assertEquals(5, num);

    }

    @Test
    public void testDecentNumberOfSongList() {

        Song s1 = new Song("abc", "b", "3");
        Song s2 = new Song("bcd", "c", "3");
        Song s3 = new Song("cde", "c", "3");
        Song s4 = new Song("def", "b", "3");
        Song s5 = new Song("efg", "c", "3");
        Song s6 = new Song("fgh", "b", "3");
        Song s7 = new Song("ghi", "b", "3");
        Song s8 = new Song("hij", "b", "3");
        Song s9 = new Song("ijk", "b", "3");
        Song s10 = new Song("jkl", "b", "3");
        Song s11 = new Song("klm", "b", "3");
        Song s12 = new Song("lmn", "b", "3");
        Song s13 = new Song("mno", "b", "3");
        Song s14 = new Song("nop", "b", "3");
        Song s15 = new Song("opq", "b", "3");
        Song s16 = new Song("pqr", "b", "3");
        Song s17 = new Song("qrs", "b", "3");
        Song s18 = new Song("rst", "b", "3");
        Song s19 = new Song("stu", "b", "3");
        Song s20 = new Song("tuv", "b", "3");



        LinkedListNode<Song> n20 = new LinkedListNode<>(s20, null);
        LinkedListNode<Song> n19 = new LinkedListNode<>(s19, n20);
        LinkedListNode<Song> n18 = new LinkedListNode<>(s18, n19);
        LinkedListNode<Song> n17 = new LinkedListNode<>(s17, n18);
        LinkedListNode<Song> n16 = new LinkedListNode<>(s16, n17);
        LinkedListNode<Song> n15 = new LinkedListNode<>(s15, n16);
        LinkedListNode<Song> n14 = new LinkedListNode<>(s14, n15);
        LinkedListNode<Song> n13 = new LinkedListNode<>(s13, n14);
        LinkedListNode<Song> n12 = new LinkedListNode<>(s12, n13);
        LinkedListNode<Song> n11 = new LinkedListNode<>(s11, n12);
        LinkedListNode<Song> n10 = new LinkedListNode<>(s10, n11);
        LinkedListNode<Song> n9 = new LinkedListNode<>(s9, n10);
        LinkedListNode<Song> n8 = new LinkedListNode<>(s8, n9);
        LinkedListNode<Song> n7 = new LinkedListNode<>(s7, n8);
        LinkedListNode<Song> n6 = new LinkedListNode<>(s6, n7);
        LinkedListNode<Song> n5 = new LinkedListNode<>(s5, n6);
        LinkedListNode<Song> n4 = new LinkedListNode<>(s4, n5);
        LinkedListNode<Song> n3 = new LinkedListNode<>(s3, n4);
        LinkedListNode<Song> n2 = new LinkedListNode<>(s2, n3);
        LinkedListNode<Song> n1 = new LinkedListNode<>(s1, n2);

        Playlist p = new Playlist(new SongTitleComparator());
        p.addSong(s11);
        p.addSong(s10);
        p.addSong(s12);
        p.addSong(s14);
        p.addSong(s13);
        p.addSong(s9);
        p.addSong(s8);
        p.addSong(s15);
        p.addSong(s7);
        p.addSong(s16);
        p.addSong(s17);
        p.addSong(s6);
        p.addSong(s1);
        p.addSong(s18);
        p.addSong(s19);
        p.addSong(s5);
        p.addSong(s4);
        p.addSong(s3);
        p.addSong(s20);
        p.addSong(s2);

        assertTrue(compareSongLists(n1, p.getSongList()));
    }

    @Test
    public void testGetExpectedEmptySongList() {

        LinkedListNode<Song> n1 = null;

        Playlist p = new Playlist(new SongBayesianRatingComparator());

        //LinkedListNode<Song> o = p.getSongList();
//        System.out.println(n2.getValue().getSongID());
//        System.out.println(n2.getValue().getRatings().getValue().getRating());
//
//        System.out.println(n3.getValue().getSongID());
//        System.out.println(n4.getValue().getSongID());
//        System.out.println(n5.getValue().getSongID());
//        System.out.println(n6.getValue().getSongID());


        assertTrue(compareSongLists(n1, p.getSongList()));
    }

    @Test
    public void testGetExpectedIdenticalRatingSongList() {

        Song s1 = new Song("a", "b", "31345");
        s1.addRating(new Rating("3", 3));
        Song s2 = new Song("b", "c", "73456");
        s2.addRating(new Rating("3", 4));
        Song s3 = new Song("c", "c", "943");
        s3.addRating(new Rating("3", 5));
        Song s4 = new Song("d", "b", "17");
        s4.addRating(new Rating("3", 1));
        Song s5 = new Song("e", "c", "1111111");
        s5.addRating(new Rating("3", 2));
        Song s6 = new Song("e", "c", "1111111");
        s6.addRating(new Rating("3", 2));
        Song s7 = new Song("e", "c", "1111111");
        s7.addRating(new Rating("3", 2));

        LinkedListNode<Song> n8 = new LinkedListNode<>(s4, null);
        LinkedListNode<Song> n7 = new LinkedListNode<>(s5, n8);
        LinkedListNode<Song> n6 = new LinkedListNode<>(s6, n7);
        LinkedListNode<Song> n5 = new LinkedListNode<>(s7, n6);
        LinkedListNode<Song> n4 = new LinkedListNode<>(s1, n5);
        LinkedListNode<Song> n3 = new LinkedListNode<>(s2, n4);
        LinkedListNode<Song> n2 = new LinkedListNode<>(s3, n3);

        Playlist p = new Playlist(new SongBayesianRatingComparator());
        p.addSong(s1);
        p.addSong(s2);
        p.addSong(s3);
        p.addSong(s4);
        p.addSong(s5);
        p.addSong(s6);
        p.addSong(s7);

        //LinkedListNode<Song> o = p.getSongList();
//        System.out.println(n2.getValue().getSongID());
//        System.out.println(n2.getValue().getRatings().getValue().getRating());
//
//        System.out.println(n3.getValue().getSongID());
//        System.out.println(n4.getValue().getSongID());
//        System.out.println(n5.getValue().getSongID());
//        System.out.println(n6.getValue().getSongID());


        assertTrue(compareSongLists(n2, p.getSongList()));
    }

    @Test
    public void testGetExpectedDuplicateRatingSongList() {

        Song s1 = new Song("a", "b", "31345");
        s1.addRating(new Rating("3", 3));
        Song s2 = new Song("b", "c", "73456");
        s2.addRating(new Rating("3", 4));
        Song s3 = new Song("c", "c", "943");
        s3.addRating(new Rating("3", 5));
        Song s4 = new Song("d", "b", "17");
        s4.addRating(new Rating("3", 1));
        Song s5 = new Song("e", "c", "1111111");
        s5.addRating(new Rating("3", 2));
        Song s6 = new Song("e", "c", "1111111");
        s6.addRating(new Rating("3", 2));
        Song s7 = new Song("e", "c", "1111111");
        s7.addRating(new Rating("3", 2));

        LinkedListNode<Song> n8 = new LinkedListNode<>(s4, null);
        LinkedListNode<Song> n7 = new LinkedListNode<>(s5, n8);
        LinkedListNode<Song> n6 = new LinkedListNode<>(s6, n7);
        LinkedListNode<Song> n5 = new LinkedListNode<>(s7, n6);
        LinkedListNode<Song> n4 = new LinkedListNode<>(s1, n5);
        LinkedListNode<Song> n3 = new LinkedListNode<>(s2, n4);
        LinkedListNode<Song> n2 = new LinkedListNode<>(s3, n3);

        Playlist p = new Playlist(new SongBayesianRatingComparator());
        p.addSong(s1);
        p.addSong(s2);
        p.addSong(s3);
        p.addSong(s4);
        p.addSong(s5);
        p.addSong(s6);
        p.addSong(s7);

        //LinkedListNode<Song> o = p.getSongList();
//        System.out.println(n2.getValue().getSongID());
//        System.out.println(n2.getValue().getRatings().getValue().getRating());
//
//        System.out.println(n3.getValue().getSongID());
//        System.out.println(n4.getValue().getSongID());
//        System.out.println(n5.getValue().getSongID());
//        System.out.println(n6.getValue().getSongID());


        assertTrue(compareSongLists(n2, p.getSongList()));
    }

    @Test
    public void testGetSongTree() {

        Song s1 = new Song("a", "b", "3");
        Song s7 = new Song("aa", "b", "3");
        Song s2 = new Song("b", "c", "3");
        Song s3 = new Song("c", "c", "3");
        Song s4 = new Song("d", "b", "3");
        Song s5 = new Song("e", "c", "3");
        Song s6 = new Song("f", "b", "3");

        BinaryTreeNode<Song> root = new BinaryTreeNode<Song>(s1, null, null);
        root.setRight(new BinaryTreeNode<>(s2, null, null));
        root.getRight().setLeft(new BinaryTreeNode<>(s7, null, null));
        root.getRight().setRight(new BinaryTreeNode<>(s3, null, null));
        root.getRight().getRight().setRight(new BinaryTreeNode<>(s4, null, null));
        root.getRight().getRight().getRight().setRight(new BinaryTreeNode<>(s5, null, null));
        root.getRight().getRight().getRight().getRight().setRight(new BinaryTreeNode<>(s6, null, null));

        Playlist p = new Playlist(new SongTitleComparator());

        p.addSong(s1);
        p.addSong(s2);
        p.addSong(s3);
        p.addSong(s4);
        p.addSong(s5);
        p.addSong(s6);
        p.addSong(s7);

        assertTrue(compareSongTrees(root, p.getSongTree()));

    }

//    @Test
//    public void testGetExpectedSongTree() {
//
//        Song s1 = new Song("a", "b", "3");
//        s1.addRating(new Rating("3", 3));
//        Song s2 = new Song("b", "c", "3");
//        s2.addRating(new Rating("3", 4));
//        Song s3 = new Song("c", "c", "3");
//        s3.addRating(new Rating("3", 5));
//        Song s4 = new Song("d", "b", "3");
//        s4.addRating(new Rating("3", 1));
//        Song s5 = new Song("e", "c", "3");
//        s5.addRating(new Rating("3", 2));
//
////        BinaryTreeNode<Song> root = new BinaryTreeNode<Song>(s4, null, null);
////        root.setRight(new BinaryTreeNode<>(s5, null, null));
////        root.getRight().setRight(new BinaryTreeNode<>(s1, null, null));
////        root.getRight().getRight().setRight(new BinaryTreeNode<>(s2, null, null));
////        root.getRight().getRight().getRight().setRight(new BinaryTreeNode<>(s3, null, null));
//
//        BinaryTreeNode<Song> root = new BinaryTreeNode<Song>(s3, null, null);
//        root.setRight(new BinaryTreeNode<>(s2, null, null));
//        root.getRight().setRight(new BinaryTreeNode<>(s1, null, null));
//        root.getRight().getRight().setRight(new BinaryTreeNode<>(s5, null, null));
//        root.getRight().getRight().getRight().setRight(new BinaryTreeNode<>(s4, null, null));
//
//        Playlist p = new Playlist(new SongBayesianRatingComparator());
//
//        p.addSong(s1);
//        p.addSong(s2);
//        p.addSong(s3);
//        p.addSong(s4);
//        p.addSong(s5);
//
//        assertTrue(compareSongTrees(root, p.getSongTree()));
//
//    }
//
//    @Test
//    public void testGetDecentNumberOfSongTree() {
//
//        Song s1 = new Song("a", "b", "3");
//        Song s2 = new Song("b", "c", "3");
//        Song s3 = new Song("c", "c", "3");
//        Song s4 = new Song("d", "b", "3");
//        Song s5 = new Song("e", "c", "3");
//        Song s6 = new Song("f", "b", "3");
//        Song s7 = new Song("g", "b", "3");
//        Song s8 = new Song("h", "b", "3");
//        Song s9 = new Song("i", "b", "3");
//        //Song s10 = new Song("j", "b", "3");
//
//        BinaryTreeNode<Song> root = new BinaryTreeNode<Song>(s5, null, null);
//        root.setRight(new BinaryTreeNode<>(s4, null, null));
//        root.getRight().setRight(new BinaryTreeNode<>(s6, null, null));
//        root.getRight().setRight(new BinaryTreeNode<>(s3, null, null));
//        root.getRight().getRight().setRight(new BinaryTreeNode<>(s7, null, null));
//        root.getRight().getRight().getRight().setRight(new BinaryTreeNode<>(s2, null, null));
//        root.getRight().getRight().getRight().getRight().setRight(new BinaryTreeNode<>(s8, null, null));
//        root.getRight().getRight().getRight().getRight().getRight().setRight(new BinaryTreeNode<>(s1, null, null));
//        root.getRight().getRight().getRight().getRight().getRight().getRight().setRight(new BinaryTreeNode<>(s9, null, null));
//        //root.getRight().getRight().getRight().getRight().getRight().getRight().getRight().setRight(new BinaryTreeNode<>(s10, null, null));
//
//        Playlist p = new Playlist(new SongTitleComparator());
//
//        p.addSong(s5);
//        p.addSong(s4);
//        p.addSong(s6);
//        p.addSong(s3);
//        p.addSong(s7);
//        p.addSong(s2);
//        p.addSong(s8);
//        p.addSong(s1);
//        p.addSong(s9);
//        //p.addSong(s10);
//
//        assertTrue(compareSongTrees(root, p.getSongTree()));
//
//    }

}