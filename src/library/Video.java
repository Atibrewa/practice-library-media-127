package library;

public class Video implements Media{
    private String title;
    private String director;
    private int numOfCopies;
    private int totalCopies;

    public Video(String title, String director, int totalCopies) {
        this.title = title;
        this.director = director;
        this.totalCopies = totalCopies;
        numOfCopies = totalCopies;
    }

    public boolean checkOut() {
        if (numOfCopies > 0) {
            numOfCopies -= 1;
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIn() {
        if (numOfCopies < totalCopies) {
            numOfCopies += 1;
            return true;
        } else {
            return false;
        }
    }
    
    public String toString() {
        return title + " directed by " + director + ", " + numOfCopies+" avalaible";
    }

    public String getTitle() {
        return title;
    }

}
