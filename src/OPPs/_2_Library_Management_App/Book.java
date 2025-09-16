package OPPs._2_Library_Management_App;

public class Book {
    public String bookId;
    public String title;
    public String author;
    public boolean available;

    public Book(String bookId, String title, String author, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = available;
    }
}
