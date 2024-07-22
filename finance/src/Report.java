import java.util.List;

public class Report {
    private List<Transaction> transactions;

    public Report(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void generate() {
        double totalIncome = 0.0;
        double totalExpenses = 0.0;

        for (Transaction transaction : transactions) {
            if (transaction.getType().equals("income")) {
                totalIncome += transaction.getAmount();
            } else if (transaction.getType().equals("expense")) {
                totalExpenses += transaction.getAmount();
            }
        }

        System.out.println("\nFinancial Report:");
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Net Balance: " + (totalIncome - totalExpenses));
    }
}
