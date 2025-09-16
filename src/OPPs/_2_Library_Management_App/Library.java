package OPPs._2_Library_Management_App;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Library {

    Map<String, User> users = new HashMap<>();
    Map<String, Book> books = new HashMap<>();
    Map<String, List<BorrowRecord>> borrowedBooks = new HashMap<>();
    Map<String, List<ReturnedRecord>> returnedBooks = new HashMap<>();
    int bookCounter = 1;
    int maxBook = 5;
    int maxDays = 15;

    public String registerUser(String name, String email) {
        if (users.containsKey(email)) {
            return "User already Exists";
        }
        users.put(email, new User(name, email, 0));
        borrowedBooks.put(email, new ArrayList<>());
        returnedBooks.put(email, new ArrayList<>());
        return "Success";
    }

    public String addBook(String title, String author) {
        String bookId = String.format("BOOK%03d", bookCounter++);
        Book book = new Book(bookId, title, author, true);
        books.put(bookId, book);
        return "Success";
    }

    public String issueBook(String email, String bookId, LocalDate issueDate) {

        if (!users.containsKey(email)) {
            System.out.println("No User Found");
            return "Error";
        }

        if (!books.containsKey(bookId) || !books.get(bookId).available) {
            System.out.println("Book Not available");
            return "Error";
        }
        User user = users.get(email);
        if (user.borrowedBooksNumber > maxBook) {
            System.out.println("You have reached the max limit");
            return "Error";
        }
        user.borrowedBooksNumber = user.borrowedBooksNumber + 1;
        users.put(email, new User(user.name, email, user.borrowedBooksNumber));
        borrowedBooks.get(email).add(new BorrowRecord(bookId, LocalDate.now()));
        books.get(bookId).available = false;

        return "Success";
    }

    public String returnBook(String email, String bookId, LocalDate returnDate) {

        if (!users.containsKey(email)) {
            System.out.println("No User Found");
            return "Error";
        }

        if (!books.containsKey(bookId) || books.get(bookId).available) {
            System.out.println("Book Not available");
            return "Error";
        }
        User user = users.get(email);
        user.borrowedBooksNumber = user.borrowedBooksNumber - 1;
        if (user.borrowedBooksNumber < 0) {
            System.out.println("You have reached the min limit");
            return "Error";
        }
        users.put(email, new User(user.name, email, user.borrowedBooksNumber));
        returnedBooks.get(email).add(new ReturnedRecord(bookId, LocalDate.now()));
        books.get(bookId).available = true;

        return "Success";
    }

    public List<Book> listAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Map.Entry<String, Book> bookEntry : books.entrySet()) {
            String bookId = bookEntry.getKey();
            Book book = bookEntry.getValue();
            if (book.available) {
                availableBooks.add(book);
            }
        }

        return availableBooks;
    }

    public List<Book> listUserBooks(String email) {
        List<Book> availableBooks = new ArrayList<>();

        List<BorrowRecord> borrowedBook = borrowedBooks.get(email);

        for (BorrowRecord it : borrowedBook) {
            String borrowBookId = it.bookId;
            for (Map.Entry<String, Book> bookEntry : books.entrySet()) {
                String bookId = bookEntry.getKey();
                Book book = bookEntry.getValue();
                if (bookId.equals(borrowBookId)) {
                    availableBooks.add(book);
                    continue;
                }
            }
        }

        return availableBooks;
    }

    public int calculateFine(String bookId, LocalDate returnDate) {
        long days = 0;

        for (Map.Entry<String, List<BorrowRecord>> borrowedBooks : borrowedBooks.entrySet()) {

            String email = borrowedBooks.getKey();
            List<BorrowRecord> borrowRecordList = borrowedBooks.getValue();

            for (BorrowRecord it : borrowRecordList) {
                if (bookId.equals(it.bookId)) {
                    days = ChronoUnit.DAYS.between(it.issueDate, returnDate);
                }
            }

        }

        return (int) (days * 0.5);
    }
}
