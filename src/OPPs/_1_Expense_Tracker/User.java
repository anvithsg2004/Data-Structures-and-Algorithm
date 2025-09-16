package OPPs._1_Expense_Tracker;

public class User {
    String name;
    String email;
    double salary;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.salary = 0;
    }

    public User(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }
}
