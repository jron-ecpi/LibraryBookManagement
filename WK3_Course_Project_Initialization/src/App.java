/**
 * Name: Jaymee Ronquillo
 * Date: May 27, 2026
 * Assignment: Course Project Week 3 - Library Book Management System
 * Description: Main class that runs the Library Book Management System.
 */

import java.util.Scanner;

public class App {

    // Scanner object
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Library library = new Library();

        FileManager fileManager = new FileManager("libraryData.txt");

        // Load existing books
        library.getBooks().addAll(fileManager.loadBooks());

        int choice;

        do {

            displayMenu();

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();

                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Book newBook = new Book(title, author, genre, id, true);

                    library.addBook(newBook);

                    break;

                case 2:

                    System.out.print("Enter Book ID to Remove: ");
                    int removeID = scanner.nextInt();

                    library.removeBook(removeID);

                    break;

                case 3:

                    System.out.print("Enter Keyword to Search: ");
                    String keyword = scanner.nextLine();

                    library.searchBook(keyword);

                    break;

                case 4:

                    library.displayBooks();

                    break;

                case 5:

                    library.displayAvailableBooks();

                    break;

                case 6:

                    System.out.print("Enter Book ID: ");
                    int updateID = scanner.nextInt();

                    System.out.print("Enter Status (true = available, false = checked out): ");
                    boolean status = scanner.nextBoolean();

                    library.updateBookStatus(updateID, status);

                    break;

                case 7:

                    fileManager.saveBooks(library.getBooks());

                    System.out.println("Exiting program...");

                    break;

                default:

                    System.out.println("Invalid option.\n");
            }

        } while (choice != 7);
    }

    // Display menu
    public static void displayMenu() {

        System.out.println("===== Library Book Management System =====");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Search Book");
        System.out.println("4. Display All Books");
        System.out.println("5. Display Available Books");
        System.out.println("6. Update Book Status");
        System.out.println("7. Save and Exit");
        System.out.print("Enter your choice: ");
    }
}