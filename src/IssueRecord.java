import java.sql.Date;

public class IssueRecord {
    private int issueId;
    private int bookId;
    private int userId;
    private Date issueDate;
    private Date returnDate;
    private double fine;

    public IssueRecord(int bookId, int userId) {
        this.bookId = bookId;
        this.userId = userId;
    }
}
