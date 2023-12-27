package domain;


import Services.TransactionLogger;

import java.time.LocalDate;
import java.util.List;

public class Transaction {
    private Long id;
    private LocalDate date;
    private double amount;
    private String description;
    private Account senderAccount;
    private Account receiverAccount;
    private String type;

    public Transaction(LocalDate date, double amount, String description, Account senderAccount, Account receiverAccount, String type) {
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.type = type;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean makeTransaction() {
        TransactionLogger transactionLogger = new TransactionLogger();
        if (senderAccount != null && receiverAccount != null && amount > 0) {
            double initialSenderBalance = senderAccount.getBalance();
            double initialReceiverBalance = receiverAccount.getBalance();

            if (senderAccount.withdraw(amount) && receiverAccount.deposit(amount, senderAccount)) {
                transactionLogger.logTransaction(this);
                return true;
            } else {
                senderAccount.setBalance(initialSenderBalance);
                receiverAccount.setBalance(initialReceiverBalance);
                return false;
            }
        }
        return false;
    }

    public boolean validate() {
        return id != null && date != null && amount >= 0 && senderAccount != null && receiverAccount != null && !type.isEmpty();
    }

    public void logTransaction() {
        System.out.println("Transaction ID: " + id);
        System.out.println("Date: " + date);
        System.out.println("Amount: " + amount);
        System.out.println("Description: " + description);
        System.out.println("Sender Account: " + senderAccount.getOwner().getName());
        System.out.println("Receiver Account: " + receiverAccount.getOwner().getName());
        System.out.println("Type: " + type);
    }



}
