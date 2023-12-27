package domain;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Account {
    private Long id;
    private String accountType;
    private double balance;
    private User owner;
    private List<Transaction> transactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void deposit(double amount, Account sender) {
        if (amount > 0) {
            this.balance += amount;

            Transaction depositTransaction = new Transaction(
                    LocalDate.now(),
                    amount,
                    "Deposit",
                    sender,
                    this,
                    "Deposit"
            );

            this.transactions.add(depositTransaction);

            System.out.println("Deposit of " + amount + " made successfully.");
        } else {
            System.out.println("Invalid deposit amount. Please provide a positive value.");
        }
    }

    public boolean withdraw(double amount) {
        Date date = new Date();
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;

            Transaction withdrawTransaction = new Transaction(
                    LocalDate.now(),
                    amount,
                    "Withdrawal amount: " + amount,
                    this,
                    null,
                    "Withdrawal"
            );

            this.transactions.add(withdrawTransaction);

            System.out.println("Withdrawal of " + amount + " made successfully.");
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
            return false;
        }
    }

    public boolean transfer(double amount, Account receiver, LocalDate date) {
        if (withdraw(amount)) {
            receiver.deposit(amount, this);
            Transaction transferTransaction = new Transaction(
                    date,
                    amount,
                    "Transfer to " + receiver.getOwner().getName(),
                    this,
                    receiver,
                    "Transfer"
            );
            this.transactions.add(transferTransaction);
            System.out.println("Transfer of " + amount + " to account " + receiver.getId() + " made successfully.");
            return true;
        } else {
            System.out.println("Transfer failed: Insufficient balance or invalid amount.");
            return false;
        }
    }




}
