package Services;

import domain.Transaction;

public class TransactionLogger {
    public void logTransaction(Transaction transaction) {
        System.out.println("Transaction ID: " + transaction.getId());
        System.out.println("Date: " + transaction.getDate());
        System.out.println("Amount: " + transaction.getAmount());
        System.out.println("Description: " + transaction.getDescription());
        System.out.println("Sender Account: " + transaction.getSenderAccount().getOwner().getName());
        System.out.println("Receiver Account: " + transaction.getReceiverAccount().getOwner().getName());
        System.out.println("Type: " + transaction.getType());
    }
}
