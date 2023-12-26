package domain;


import java.util.List;

public class Account {
    private Long id;
    private String accountType;
    private double balance;
    private User owner;
    private List<Transaction> transactions;
}
