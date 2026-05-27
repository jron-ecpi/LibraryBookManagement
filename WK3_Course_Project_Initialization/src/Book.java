/**
 * Name: Jaymee Ronquillo
 * Date: May 27, 2026
 * Assignment: Course Project Week 3 - Library Book Management System
 * Description: Represents a single book object in the library system.
 */

public class Book {

    // Private fields for encapsulation
    private String title;
    private String author;
    private String genre;
    private int bookID;
    private boolean available;

    // Constructor
    public Book(String title, String author, String genre, int bookID, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.available = available;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getBookID() {
        return bookID;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setter method
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // toString method
    @Override
    public String toString() {

        String status;

        if (available) {
            status = "Available";
        } else {
            status = "Checked Out";
        }

        return "Book ID: " + bookID +
                "\nTitle: " + title +
                "\nAuthor: " + author +
                "\nGenre: " + genre +
                "\nStatus: " + status +
                "\n";
    }
}