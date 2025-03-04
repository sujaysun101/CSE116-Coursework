package ratings;

import ratings.datastructures.LinkedListNode;

public class Ratable {
    private String title;
    private LinkedListNode<Rating> currentNode;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addRating(Rating r) {
        LinkedListNode<Rating> cursor = currentNode;
        if (this.currentNode == null) {
            currentNode = new LinkedListNode<Rating>(r, null);
        } else {
            if (cursor.getNext() == null) {
                cursor.setNext(new LinkedListNode<>(r, null));
            } else {
                while (cursor.getNext() != null) {
                    cursor = cursor.getNext();
                    if (cursor.getNext() == null) {
                        cursor.setNext(new LinkedListNode<>(r, null));
                        break;
                    }
                }

            }
        }
    }

    public LinkedListNode<Rating> getRatings() {
        return this.currentNode;
    }

    public void setRatings(LinkedListNode<Rating> r2) {
        this.currentNode = r2;
    }

    public double averageRating() {
        double total = 0.0;
        double num = 0.0;
        double avg = 0.0;
        LinkedListNode<Rating> cursor = this.currentNode;
        if (cursor == null) {
            return 0.0;
        }
        /*else if (currentNode.getNext() == null) {
            total = currentNode.getValue().getRating();
            num = 1;
        }*/
        while (cursor != null) {
            if (cursor.getValue().getRating() != -1) {
                total += cursor.getValue().getRating();
                num++;
            }
            cursor = cursor.getNext();
            //currentNode = currentNode.getNext();
        }
        if (num == 0.0) {
            return avg;
        }
        avg = total / num;
        return avg;

        //double avg = total/num;
        //return avg;
    }

    public void removeRatingByReviewer(Reviewer re) {
        LinkedListNode<Rating> cursor2 = currentNode;
        LinkedListNode<Rating> preCursor = currentNode;
        if (this.currentNode != null) {
            if (this.currentNode.getValue().getReviewerID().equals(re.getReviewerID())) {
                this.currentNode = this.currentNode.getNext();
                return;
            }
            while (cursor2 != null) {
                if (cursor2.getNext().getValue().getReviewerID().equals(re.getReviewerID())) {
                    cursor2.setNext(cursor2.getNext().getNext());
                    return;
                }
                cursor2 = cursor2.getNext();
            }
        }
    }

    public double total() {
        double total = 0.0;
        double num = 0.0;
        LinkedListNode<Rating> cursor = this.currentNode;
        while (cursor != null) {
            if (cursor.getValue().getRating() != -1) {
                total += cursor.getValue().getRating();
                //num++;
            }
            cursor = cursor.getNext();
            //return total;
        }
        return total;
    }

        public double num() {
            double num = 0.0;
            LinkedListNode<Rating> cursor = this.currentNode;
            while (cursor != null) {
                if (cursor.getValue().getRating() != -1) {
                    num++;
                }
                cursor = cursor.getNext();
            }
            return num;
        }


            public double bayesianAverageRating (int num, int value){
            if(value < 0 || value > 5) {
                return 0.0;
            }
            double newTotal = total();
            double newNum = num();
            double newAvg = 0.0;
            if (num == 0) {
                if(newNum == 0.0){
                    return 0.0;
                }
                newAvg = newTotal/newNum;
                return newAvg;
            } else if (newTotal == 0.0 && newNum == 0.0) {
                return value;
            }
            double newnewNum = newNum + num;
            while (num > 0) {
                newTotal += value;
                num--;
            }
            //newnewNum += num;
            newAvg = newTotal / newnewNum;
            return newAvg;
        }
    }
