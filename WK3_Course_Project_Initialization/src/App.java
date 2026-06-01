/**
 * Name: Jaymee Ronquillo
 * Date: June 1, 2026
 * Assignment: Course Project Week 4 - SQLite Database Support
 * Description: Main class using SQLite database CRUD operations.
 */

import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Jaymee Ronquillo - Week 4 Database PA");

        DatabaseManager.createTable();

        BookDAO dao = new BookDAO();

        // Insert 4 books (only if you want duplicates, otherwise skip after first run)
        dao.addBook(new Book("Book A", "Author A", "Fiction", 1, true));
        dao.addBook(new Book("Book B", "Author B", "Sci-Fi", 2, true));
        dao.addBook(new Book("Book C", "Author C", "Horror", 3, false));
        dao.addBook(new Book("Book D", "Author D", "Mystery", 4, true));

        // READ ALL
        System.out.println("\n--- All Books ---");
        for (Book b : dao.getAllBooks()) {
            System.out.println(b);
        }

        // INVALID ID TEST
        System.out.println("\n--- Invalid ID Lookup ---");
        Book invalid = dao.getBookById(999);
        System.out.println(invalid == null ? "No book found." : invalid);

        // UPDATE
        System.out.println("\n--- Updating Book ID 1 ---");
        Book update = dao.getBookById(1);
        if (update != null) {
            update.setAvailable(false);
            dao.updateBook(update);
            System.out.println(dao.getBookById(1));
        }

        // DELETE
        System.out.println("\n--- Deleting Book ID 2 ---");
        dao.deleteBook(2);

        // FINAL LIST
        System.out.println("\n--- After Deletion ---");
        for (Book b : dao.getAllBooks()) {
            System.out.println(b);
        }
    }
}