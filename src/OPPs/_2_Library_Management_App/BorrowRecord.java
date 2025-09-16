package OPPs._2_Library_Management_App;

import java.time.*;

public class BorrowRecord {
    public String bookId;
    public LocalDate issueDate;

    public BorrowRecord(String bookId, LocalDate issueDate) {
        this.bookId = bookId;
        this.issueDate = issueDate;
    }
}
