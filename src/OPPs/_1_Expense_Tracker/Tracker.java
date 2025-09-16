package OPPs._1_Expense_Tracker;

import java.time.*;
import java.util.*;

public class Tracker {

    Map<String, User> users = new HashMap<>();
    Map<String, List<Income>> incomes = new HashMap<>();
    Map<String, List<Expense>> expense = new HashMap<>();

    public String createUser(String name, String email) {
        if (users.containsKey(email)) {
            return "User Already there.";
        }
        users.put(email, new User(name, email));
        incomes.put(email, new ArrayList<>());
        expense.put(email, new ArrayList<>());
        return "Success";
    }

    public String addIncome(String email, String description, double amount, LocalDate date, String category) {
        if (!users.containsKey(email)) {
            return "User Not Found";
        }

        // Updating Salary
        User u = users.get(email);
        u.salary = u.salary + amount;
        users.put(email, new User(u.name, email, u.salary));

        // Adding Income
        incomes.get(email).add(new Income(description, amount, date, category));
        return "Success";
    }

    public String addExpense(String email, String description, double amount, LocalDate date, String category) {

        if (!users.containsKey(email)) {
            return "User Not Found";
        }

        // Updating Salary
        User u = users.get(email);
        u.salary = u.salary - amount;

        if (u.salary < 0) {
            return "Invalid Expense";
        }

        users.put(email, new User(u.name, email, u.salary));

        // Adding Income
        expense.get(email).add(new Expense(description, amount, date, category));

        return "Success";
    }

    public Set<String> listAllCategories() {
        Set<String> availableCategories = new HashSet<>();
        for (Map.Entry<String, List<Income>> entry : incomes.entrySet()) {
            String userId = entry.getKey();
            List<Income> incomeList = entry.getValue();
            for (Income income : incomeList) {
                availableCategories.add(income.category);

            }
        }
        for (Map.Entry<String, List<Expense>> entry : expense.entrySet()) {
            String userId = entry.getKey();
            List<Expense> expenseList = entry.getValue();
            for (Expense exp : expenseList) {
                availableCategories.add(exp.category);
            }
        }
        return availableCategories;
    }

    public boolean validateCategory(String category) {
        try {
            Category.valueOf(category.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public void getTransactionHistory(String email) {

        System.out.println("User Expenses : \n");
        int expenses = 1;
        for (Map.Entry<String, List<Expense>> exp : expense.entrySet()) {
            String userEmail = exp.getKey();
            List<Expense> userExpense = exp.getValue();

            if (userEmail.equals(email)) {
                for (Expense ex : userExpense) {
                    System.out.println(expenses + " : Description: " + ex.description + ", Amount: " + ex.amount + ", Date: " + ex.date);
                    expenses++;
                }

            }

        }

        System.out.println("User Expenses : \n");
        int inco = 1;
        for (Map.Entry<String, List<Income>> exp : incomes.entrySet()) {
            String userEmail = exp.getKey();
            List<Income> userExpense = exp.getValue();

            if (userEmail.equals(email)) {
                for (Income ex : userExpense) {
                    System.out.println(inco + " : Description: " + ex.description + ", Amount: " + ex.amount + ", Date: " + ex.date);
                    inco++;
                }

            }

        }

    }

    public void getMonthlyReport(String email, int year, int month) {
        if (!users.containsKey(email)) {
            System.out.println("User not found.");
            return;
        }

        double totalIncome = 0.0;
        double totalExpense = 0.0;

        System.out.println("Monthly Report for " + users.get(email).name + " (" + year + "-" + month + ")");
        System.out.println("\nIncomes:");
        List<Income> incomeList = incomes.get(email);
        for (Income income : incomeList) {
            if (income.date.getYear() == year && income.date.getMonthValue() == month) {
                totalIncome = totalIncome + income.amount;
                System.out.println("Description: " + income.description + ", Amount: " + income.amount + ", Date: " + income.date + ", Category: " + income.category);
            }
        }

        System.out.println("Monthly Report for " + users.get(email).name + " (" + year + "-" + month + ")");
        System.out.println("\nExpenses:");
        List<Expense> expenseList = expense.get(email);
        for (Expense expense : expenseList) {
            if (expense.date.getYear() == year && expense.date.getMonthValue() == month) {
                totalExpense = totalExpense + expense.amount;
                System.out.println("Description: " + expense.description + ", Amount: " + expense.amount + ", Date: " + expense.date + ", Category: " + expense.category);
            }
        }

    }

    public void getCategoryReport(String email, String category, int year, int month) {
        if (!users.containsKey(email)) {
            System.out.println("User not found.");
            return;
        }

        double totalIncome = 0;
        double totalExpense = 0;

        System.out.println("Category Report for " + users.get(email).name + " (" + category + ", " + year + "-" + month + ")\n");

        System.out.println("Incomes:");
        for (Income income : incomes.get(email)) {
            if (income.category.equalsIgnoreCase(category) && income.date.getYear() == year && income.date.getMonthValue() == month) {
                totalIncome += income.amount;
                System.out.println("Description: " + income.description + ", Amount: " + income.amount + ", Date: " + income.date);
            }
        }

        System.out.println("\nExpenses:");
        for (Expense exp : expense.get(email)) {
            if (exp.category.equalsIgnoreCase(category) && exp.date.getYear() == year && exp.date.getMonthValue() == month) {
                totalExpense += exp.amount;
                System.out.println("Description: " + exp.description + ", Amount: " + exp.amount + ", Date: " + exp.date);
            }
        }

        System.out.println("\nSummary:");
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expense: " + totalExpense);
        System.out.println("Net Balance: " + (totalIncome - totalExpense));
    }

    public void getDateRangeReport(String email, LocalDate startDate, LocalDate endDate) {
        if (!users.containsKey(email)) {
            System.out.println("User not found.");
            return;
        }

        double totalIncome = 0;
        double totalExpense = 0;

        System.out.println("Date Range Report for " + users.get(email).name + " (" + startDate + " to " + endDate + ")\n");

        System.out.println("Incomes:");
        for (Income income : incomes.get(email)) {
            if (!income.date.isBefore(startDate) && !income.date.isAfter(endDate)) {
                totalIncome += income.amount;
                System.out.println("Description: " + income.description + ", Amount: " + income.amount + ", Date: " + income.date + ", Category: " + income.category);
            }
        }

        System.out.println("\nExpenses:");
        for (Expense exp : expense.get(email)) {
            if (!exp.date.isBefore(startDate) && !exp.date.isAfter(endDate)) {
                totalExpense += exp.amount;
                System.out.println("Description: " + exp.description + ", Amount: " + exp.amount + ", Date: " + exp.date + ", Category: " + exp.category);
            }
        }

        System.out.println("\nSummary:");
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expense: " + totalExpense);
        System.out.println("Net Balance: " + (totalIncome - totalExpense));
    }

}
