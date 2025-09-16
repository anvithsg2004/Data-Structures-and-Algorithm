package OPPs._2_Library_Management_App;

import java.util.List;

public class User {
    String name;
    String email;
    int borrowedBooksNumber;

    public User(String name, String email, int borrowedBooksNumber) {
        this.name = name;
        this.email = email;
        this.borrowedBooksNumber = borrowedBooksNumber;
    }
}
