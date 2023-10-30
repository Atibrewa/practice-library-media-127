package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Interactive console simulation of a library.
 *
 * @author Abby Marsh Fall 2019
 */
public class LibraryMain {
    /**
     * Helper method to check an item out from the library
     * @param title title of item to check out
     * @param library list of library items
     * @return true if item checked out successfully, false otherwise
     */
    public static boolean checkOut(String title, List<Media> library) {
        for(Media media : library) {
            if(media.getTitle().equalsIgnoreCase(title)) {
                return media.checkOut();
            }
        }
        return false;
    }

    /**
     * Helper method to check an item in to the library
     *
     * @param title title of item to check in
     * @param library list of library items
     * @return true if item checked in successfully, false otherwise
     */
    public static boolean checkIn(String title, List<Media> library) {
        for(Media media : library) {
            if(media.getTitle().equalsIgnoreCase(title)) {
                return media.checkIn();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // create/populate library
        List<Media> library = new ArrayList<>();

        library.add(new Book("American Gods", "Neil Gaiman"));
        library.add(new Book("The Yiddish Policeman's Union", "Michael Chabon"));
        library.add(new Book("Pond", "Claire-Louise Bennett"));
        library.add(new Book("The Dream Songs", "John Berryman"));
        library.add(new Book("The Dud Avocado", "Elaine Dundy"));
        
        library.add(new Video("The Martian", "Ridley Scott", 3));
        library.add(new Video("The Croods", "Chris Snaders", 4));
        library.add(new Video("Inception", "Christopher Nolan", 2));

        // begin user prompts
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\nEnter a command to perform an action. Type \'help\' to see the list of commands");
            System.out.print("> ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("quit")) { // quit to exit
                break;
            }

            if(input.equalsIgnoreCase("help")) { // print list of commands
                showHelp();

            } else if (input.matches("checkout .+")) { // checking out an item
                if (checkOut(input.substring(9), library)) {
                    System.out.println("Checked out " + input.substring(9));
                } else {
                    System.out.println("Could not check out that title.");
                }

            } else if (input.matches("checkin .+")) { // checking in an item
                if(checkIn(input.substring(8), library)) {
                    System.out.println("Checked in " + input.substring(8));
                } else {
                    System.out.println("Could not check in that title.");
                }

            } else if (input.equalsIgnoreCase("list")) { // list all library items
                listBooks(library);

            } else { // invalid command
                System.out.println("Please enter a valid command");
            }
        }
        sc.close();
    }

    private static void listBooks(List<Media> library) {
        System.out.println("\n-----\nLibrary Inventory\n-----\n");

        for(Media media : library) {
            System.out.println(media.toString());
        }
    }

    private static void showHelp() {
        System.out.println("The following commands are accepted:");
        System.out.println("\'list\': list all library items and whether they are available");
        System.out.println("\'checkout [title]\': checkout the item called [title]");
        System.out.println("\'checkin [title]\': checkin the item called [title]");
        System.out.println("\'quit\': exit the program");
    }
}
