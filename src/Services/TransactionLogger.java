package Services;

import domain.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionLogger {
    private List<Transaction> transactionLogs;

    // Constructor
    public TransactionLogger() {
        this.transactionLogs = new ArrayList<>();
    }

    // Method to log a transaction
    public void logTransaction(Transaction transaction) {
        transactionLogs.add(transaction);
    }

    // Method to retrieve all transaction logs
    public List<Transaction> retrieveLogs() {
        return new ArrayList<>(transactionLogs);
    }
}
