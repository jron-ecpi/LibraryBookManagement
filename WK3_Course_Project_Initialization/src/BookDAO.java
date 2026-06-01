/**
 * Name: Jaymee Ronquillo
 * Date: June 1, 2026
 * Assignment: Course Project Week 4 - SQLite Database Support
 * Description: Performs CRUD operations on books table.
 */

import java.sql.*;
import java.util.ArrayList;

public class BookDAO {

    // CREATE
    public void addBook(Book book) {

        String sql = "INSERT INTO books(book_id, title, author, genre, available) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = DatabaseManager.connect().prepareStatement(sql)) {

            pstmt.setInt(1, book.getBookID());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setString(4, book.getGenre());
            pstmt.setInt(5, book.isAvailable() ? 1 : 0);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Insert error: " + e.getMessage());
        }
    }

    // READ ALL
    public ArrayList<Book> getAllBooks() {

        ArrayList<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM books";

        try (Statement stmt = DatabaseManager.connect().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                books.add(new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getInt("book_id"),
                        rs.getInt("available") == 1
                ));
            }

        } catch (SQLException e) {
            System.out.println("Read error: " + e.getMessage());
        }

        return books;
    }

    // READ ONE
    public Book getBookById(int id) {

        String sql = "SELECT * FROM books WHERE book_id = ?";

        try (PreparedStatement pstmt = DatabaseManager.connect().prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getInt("book_id"),
                        rs.getInt("available") == 1
                );
            }

        } catch (SQLException e) {
            System.out.println("Select error: " + e.getMessage());
        }

        return null;
    }

    // UPDATE
    public void updateBook(Book book) {

        String sql = "UPDATE books "
                + "SET title=?, author=?, genre=?, available=? "
                + "WHERE book_id=?";

        try (PreparedStatement pstmt = DatabaseManager.connect().prepareStatement(sql)) {

            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getGenre());
            pstmt.setInt(4, book.isAvailable() ? 1 : 0);
            pstmt.setInt(5, book.getBookID());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
        }
    }

    // DELETE
    public void deleteBook(int id) {

        String sql = "DELETE FROM books WHERE book_id=?";

        try (PreparedStatement pstmt = DatabaseManager.connect().prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
        }
    }
}