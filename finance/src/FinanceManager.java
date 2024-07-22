import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinanceManager {
    private static List<Transaction> transactions = new ArrayList<>();
    private static Account account = new Account();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to your Personal Finance Manager!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. View Account Balance");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("> ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    addTransaction(scanner, "income");
                    break;
                case "2":
                    addTransaction(scanner, "expense");
                    break;
                case "3":
                    viewTransactions();
                    break;
                case "4":
                    viewAccountBalance();
                    break;
                case "5":
                    generateReport();
                    break;
                case "6":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addTransaction(Scanner scanner, String type) {
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Transaction transaction = new Transaction(type, amount, description);
        transactions.add(transaction);
        account.updateBalance(transaction);

        System.out.println("Transaction added: " + transaction);
    }

    private static void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions to display.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    private static void viewAccountBalance() {
        System.out.println("Current account balance: " + account.getBalance());
    }

    private static void generateReport() {
        Report report = new Report(transactions);
        report.generate();
    }
}
