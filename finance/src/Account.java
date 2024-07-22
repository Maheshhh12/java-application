public class Account {
    private double balance;

    public Account() {
        this.balance = 0.0;
    }

    public void updateBalance(Transaction transaction) {
        if (transaction.getType().equals("income")) {
            balance += transaction.getAmount();
        } else if (transaction.getType().equals("expense")) {
            balance -= transaction.getAmount();
        }
    }

    public double getBalance() {
        return balance;
    }
}
