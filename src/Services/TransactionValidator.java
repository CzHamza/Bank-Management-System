package Services;

import domain.Transaction;

public class TransactionValidator {

    public boolean validate(Transaction transaction) {
        return transaction != null && transaction.validate();
    }

    public boolean checkSufficientBalance(Transaction transaction) {
        if (transaction != null && transaction.getSenderAccount() != null) {
            return transaction.getAmount() <= transaction.getSenderAccount().getBalance();
        }
        return false;
    }
}
