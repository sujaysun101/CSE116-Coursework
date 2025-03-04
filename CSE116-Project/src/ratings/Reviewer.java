package ratings;

import ratings.Rating;

public class Reviewer {
    private String id;
    public Reviewer(String id) {
        this.id = id;
    }
    public String getReviewerID() {
        return this.id;
    }
    public void setReviewerID(String id) {
        this.id = id;
    }
    public Rating rateSong(int rating) {
            return new Rating(this.id, rating);
    }
}
