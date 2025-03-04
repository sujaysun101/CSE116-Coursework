package ratings;

public class Rating {
    private String id;
    private int rating;
    public Rating(String id, int rating) {
        this.id = id;
        this.rating = rating;
        setRating(rating);
    }
    public String getReviewerID() {
        return this.id;
    }
    public void setReviewerID(String id) {
        this.id = id;
    }
    public int getRating() {
        return this.rating;
    }
    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
           this.rating = rating;
        }
        else {
            this.rating = -1;
        }
    }
}
