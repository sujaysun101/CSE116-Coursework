package ratings;

import ratings.datastructures.LinkedListNode;

public class Song extends Ratable {
    private String artist;
    private String id;

    public Song(String title, String artist, String id) {
        //this.title = title;
        setTitle(title);
        this.artist = artist;
        this.id = id;
        //this.currentNode=null;
    }
    public String getArtist() {
        return this.artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getSongID() {
        return this.id;
    }
    public void setSongID(String id) {
        this.id = id;
    }


}
