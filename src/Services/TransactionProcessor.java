package Services;

import domain.Account;
import domain.Transaction;

public class TransactionProcessor {


    public static boolean validateTransaction(Transaction transaction) {
        return transaction != null && transaction.validate();
    }

  
    public static void updateAccountBalance(Transaction transaction) {
        if (transaction != null && transaction.validate()) {
            Account senderAccount = transaction.getSenderAccount();
            Account receiverAccount = transaction.getReceiverAccount();
            double amount = transaction.getAmount();

            if (senderAccount != null && receiverAccount != null && amount > 0) {
                senderAccount.withdraw(amount);
                receiverAccount.deposit(amount, senderAccount);
            }
        }
    }

    
    public static boolean initiateRefund(Transaction transaction) {
        if (transaction != null && transaction.validate() && "Withdrawal".equals(transaction.getType())) {
            Account senderAccount = transaction.getSenderAccount();
            Account receiverAccount = transaction.getReceiverAccount();
            double amount = transaction.getAmount();

            if (senderAccount != null && receiverAccount != null && amount > 0) {
                if (senderAccount.deposit(amount, receiverAccount) && receiverAccount.withdraw(amount)) {
                    return true;
                }
            }
        }
        return false;
    }
}

