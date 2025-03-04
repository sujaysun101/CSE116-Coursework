package ratings;


import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;

public class Playlist {
    public BinaryTreeNode<Song> root;
    public Comparator<Song> c;
    public LinkedListNode<Song> LL;
    public Playlist(Comparator<Song> c) {
        this.root = null;
        this.c = c;
        this.LL=null;
    }
    public void addSong(Song s1) {
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(s1, null, null);
        } else {
            this.addSongHelper(this.root, s1);
        }
    }
    private void addSongHelper(BinaryTreeNode<Song> n1, Song toInsert) {
        if (this.c.compare(toInsert, n1.getValue())) {
            if (n1.getLeft() == null) {
                n1.setLeft(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                addSongHelper(n1.getLeft(), toInsert);
            }
        } else {
            if (n1.getRight() == null) {
                n1.setRight(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                addSongHelper(n1.getRight(), toInsert);
            }
        }
    }

    public BinaryTreeNode<Song> getSongTree() {
        return this.root;
    }

    public void setNext(LinkedListNode<Song> LL) {
    LinkedListNode<Song> newNode = this.LL;
    if (this.LL == null) {
            this.LL = LL;
        }
        else {
            while (newNode.getNext() != null) {
                newNode = newNode.getNext();
        }
        newNode.setNext(LL);
        }

    }
    public void getSongListHelper(BinaryTreeNode<Song> n1) {
        if (n1 == null) {
            return;
        }
        else {
            getSongListHelper(n1.getLeft());
            LinkedListNode<Song> r = new LinkedListNode<>(n1.getValue(), null);
            this.setNext(r);
            getSongListHelper(n1.getRight());
        }
    }
    public LinkedListNode<Song> getSongList(BinaryTreeNode<Song> b1) {
        this.getSongListHelper(b1);
        return this.LL;
    }
    public LinkedListNode<Song> getSongList() {
        return this.getSongList(root);
    }
}
