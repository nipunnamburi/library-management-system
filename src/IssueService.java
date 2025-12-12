import java.sql.*;

public class IssueService {

    public void issueBook(int bookId, int userId) {
        String sql1 = "UPDATE books SET isIssued = true WHERE id = ?";
        String sql2 = "INSERT INTO issues(bookId, userId, issueDate) VALUES (?, ?, CURDATE())";

        try (Connection conn = DatabaseConnection.getConnection()) {

            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            stmt1.setInt(1, bookId);
            stmt1.executeUpdate();

            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1, bookId);
            stmt2.setInt(2, userId);
            stmt2.executeUpdate();

            System.out.println("Book issued successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int bookId) {
        String sql1 = "UPDATE books SET isIssued = false WHERE id = ?";
        String sql2 = "UPDATE issues SET returnDate = CURDATE(), fine = DATEDIFF(CURDATE(), issueDate) * 2 WHERE bookId = ? AND returnDate IS NULL";

        try (Connection conn = DatabaseConnection.getConnection()) {

            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            stmt1.setInt(1, bookId);
            stmt1.executeUpdate();

            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1, bookId);
            stmt2.executeUpdate();

            System.out.println("Book returned!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
