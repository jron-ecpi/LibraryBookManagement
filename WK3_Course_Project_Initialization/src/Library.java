/**
 * Name: Jaymee Ronquillo
 * Date: May 27, 2026
 * Assignment: Course Project Week 3 - Library Book Management System
 * Description: Manages the collection of books in the library.
 */

import java.util.ArrayList;

public class Library {

    // Composition relationship
    private ArrayList<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.\n");
    }

    // Remove a book by ID
    public void removeBook(int id) {

        for (Book book : books) {

            if (book.getBookID() == id) {
                books.remove(book);
                System.out.println("Book removed successfully.\n");
                return;
            }
        }

        System.out.println("Book not found.\n");
    }

    // Search books by keyword
    public void searchBook(String keyword) {

        boolean found = false;

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(keyword)
                    || book.getAuthor().equalsIgnoreCase(keyword)
                    || book.getGenre().equalsIgnoreCase(keyword)) {

                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found.\n");
        }
    }

    // Display all books
    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books in the library.\n");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Display available books
    public void displayAvailableBooks() {

        boolean found = false;

        for (Book book : books) {

            if (book.isAvailable()) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available books found.\n");
        }
    }

    // Update book status
    public void updateBookStatus(int id, boolean status) {

        for (Book book : books) {

            if (book.getBookID() == id) {
                book.setAvailable(status);
                System.out.println("Book status updated successfully.\n");
                return;
            }
        }

        System.out.println("Book not found.\n");
    }

    // Getter for books ArrayList
    public ArrayList<Book> getBooks() {
        return books;
    }
}