package OPPs._2_Library_Management_App;

import java.time.LocalDate;

public class ReturnedRecord {
    public String bookId;
    public LocalDate returnDate;

    public ReturnedRecord(String bookId, LocalDate returnDate) {
        this.bookId = bookId;
        this.returnDate = returnDate;
    }
}
