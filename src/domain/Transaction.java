package domain;


import java.util.Date;

public class Transaction {
    private Long id;
    private Date date;
    private double amount;
    private String description;
    private Account senderAccount;
    private Account receiverAccount;
    private String type;

}
