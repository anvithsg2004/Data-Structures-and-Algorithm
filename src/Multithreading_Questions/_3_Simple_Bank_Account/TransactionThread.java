package Multithreading_Questions._3_Simple_Bank_Account;

class TransactionThread implements Runnable {
    private BankAccount account;
    private String userName;
    private boolean isDeposit;
    private int amount;

    public TransactionThread(BankAccount account, String userName, boolean isDeposit, int amount) {
        this.account = account;
        this.userName = userName;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount, userName);
        } else {
            account.withdraw(amount, userName);
        }
    }
}
