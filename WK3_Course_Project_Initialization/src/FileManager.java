/**
 * Name: Jaymee Ronquillo
 * Date: May 27, 2026
 * Assignment: Course Project Week 3 - Library Book Management System
 * Description: Handles file input and output operations for library data.
 */

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    // File name
    private String fileName;

    // Constructor
    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    // Save books to file
    public void saveBooks(ArrayList<Book> books) {

        try {

            PrintWriter writer = new PrintWriter(new FileWriter(fileName));

            for (Book book : books) {

                writer.println(
                        book.getTitle() + "," +
                        book.getAuthor() + "," +
                        book.getGenre() + "," +
                        book.getBookID() + "," +
                        book.isAvailable());
            }

            writer.close();

            System.out.println("Books saved successfully.\n");

        } catch (IOException e) {

            System.out.println("Error saving books to file.");
        }
    }

    // Load books from file
    public ArrayList<Book> loadBooks() {

        ArrayList<Book> books = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                String title = data[0];
                String author = data[1];
                String genre = data[2];
                int bookID = Integer.parseInt(data[3]);
                boolean available = Boolean.parseBoolean(data[4]);

                Book book = new Book(title, author, genre, bookID, available);

                books.add(book);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("No previous library data found.\n");
        }

        return books;
    }
}