import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    public void addBook(Book book) {
        String sql = "INSERT INTO books(title, author, isIssued) VALUES (?, ?, false)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.executeUpdate();
            System.out.println("Book added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getBoolean("isIssued")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
