package ratings;

import java.util.ArrayList;

public class Movie extends Ratable {
    private String title;
    private ArrayList<String> castMembers;
    public Movie(String title, ArrayList<String> castMembers) {
        this.title = title;
        setTitle(title);
        this.castMembers = castMembers;
    }
    public ArrayList<String> getCast() {
        return this.castMembers;
    }
}
