package OPPs._1_Expense_Tracker;

import java.time.*;

public class Expense {
    public String description;
    public double amount;
    public LocalDate date;
    public String category;

    public Expense(String description, double amount, LocalDate date, String category) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }
}
