package library;

/**
 * A book that is an entry in a library’s collection.
 *
 * @author Abby Marsh Fall 2019
 */
public class Book implements Media{
    private boolean isAvailable;
    private String title;
    private String author;

    public Book(String title, String author) {
        this.isAvailable = true;
        this.title = title;
        this.author = author;

    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return this.title + " by " + this.author
            + " [" + (this.isAvailable ? "available" : "checked out") + "]";
    }

    /**
     * Checks a book out of the library.
     * If the book is available, we can check it out (and mark it as no longer available).
     * If the book is not available, we cannot check it out.
     *
     * @return true if the requested book was checked out, and false if the book could not be checked out.
     */
    public boolean checkOut() {
        if(this.isAvailable) {
            this.isAvailable = false;
            return true;
        } else {
            return this.isAvailable;
        }
        /* Fun challenge: The following single line of code does the same thing as the six lines above.
           What looks unfamiliar to you? Can you figure out what the different parts are? What
           are they each doing? In what ways is this approach better and worse than the one above?
         */
        //return (this.isAvailable ? !(this.isAvailable = false) : this.isAvailable);

        /* Here is another approach that does exactly the same thing. Why does this work?
           In what ways is this approach better and worse than the others above?
        */
        // boolean wasAvailable = isAvailable;
        // isAvailable = false;
        // return wasAvailable;
    }

    /**
     * Checks a book back in to the library.
     * If the book is available, then we can't check it in--it's already here!
     * If the book is not available, we check it back in (and set it to be available again).
     *
     * @return true if the book was checked in, and false if the book could not be checked in.
     */
    public boolean checkIn() {
        if(this.isAvailable) {
            return false;
        } else {
            this.isAvailable = true;
            return this.isAvailable;
        }

        /* Fun challenge: The following single line of code does the same thing as the six lines above.
           What looks unfamiliar to you? Can you figure out what the different parts are? What
           are they each doing? In what ways is this approach better and worse than the one above?
         */
        //return (this.isAvailable ? !this.isAvailable : (this.isAvailable = true));

        /* Here is another approach that does exactly the same thing. Why does this work?
           In what ways is this approach better and worse than the others above?
        */
        // boolean wasAvailable = isAvailable;
        // isAvailable = true;
        // return !wasAvailable;
    }
}
