package OPPs._1_Expense_Tracker;

import java.time.*;

public class Income {
    public String description;
    public double amount;
    public LocalDate date;
    public String category;

    public Income(String description, double amount, LocalDate date, String category) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }
}
