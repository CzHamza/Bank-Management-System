package Services;

import domain.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionLogger {
    private List<Transaction> transactionLogs;

   
    public TransactionLogger() {
        this.transactionLogs = new ArrayList<>();
    }

   
    public void logTransaction(Transaction transaction) {
        transactionLogs.add(transaction);
    }

    
    public List<Transaction> retrieveLogs() {
        return new ArrayList<>(transactionLogs);
    }
}
