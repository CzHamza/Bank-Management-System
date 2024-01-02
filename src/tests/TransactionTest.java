package tests;

import domain.Account;
import domain.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class TransactionTest {

    private Account senderAccount;
    private Account receiverAccount;
    private Transaction transaction;

    @Before
    public void setUp() {
        senderAccount = new Account();
        senderAccount.setId(1L);
        senderAccount.setBalance(1000.0);

        receiverAccount = new Account();
        receiverAccount.setId(2L);
        receiverAccount.setBalance(500.0);

        transaction = new Transaction(LocalDate.now(), 200.0, "Test Transaction", senderAccount, receiverAccount, "Deposit");
        transaction.setId(1L);
        transaction.generateRandomTransactions(5);
    }



    @Test
    public void testMakeTransaction() {
        assertTrue(transaction.makeTransaction());

        assertEquals(800.0, senderAccount.getBalance(), 0.001);
        assertEquals(700.0, receiverAccount.getBalance(), 0.001);
    }

    @Test
    public void testMakeTransactionInsufficientFunds() {
        transaction.setAmount(1200.0);

        assertFalse(transaction.makeTransaction());

        assertEquals(1000.0, senderAccount.getBalance(), 0.001);
        assertEquals(500.0, receiverAccount.getBalance(), 0.001);
    }

    @Test
    public void testMakeTransactionNegativeAmount() {
        transaction.setAmount(-200.0);

        assertFalse(transaction.makeTransaction());

        assertEquals(1000.0, senderAccount.getBalance(), 0.001);
        assertEquals(500.0, receiverAccount.getBalance(), 0.001);
    }

    @Test
    public void testShowHistory() {
        List<Transaction> transactionList = transaction.showHistory();

        assertNotNull(transactionList);
        assertEquals(5, transactionList.size());
    }

    @Test
    public void testValidate() {
        assertTrue(transaction.validate());
    }

    @Test
    public void testGetTransactionsByDate() {
        List<Transaction> matchingTransactions = transaction.getTransactionsByDate(LocalDate.now());

        assertNotNull(matchingTransactions);
        assertTrue(matchingTransactions.size() >= 1);
    }


    @Test
    public void testGetTransactionsByAllCriteria() {
        List<Transaction> matchingTransactions = transaction.getTransactionsByAllCriteria(
                LocalDate.now(), 200.0, "Random Transaction 1",
                senderAccount, receiverAccount, "Deposit"
        );

        assertNotNull(matchingTransactions);
        assertTrue(matchingTransactions.size() >= 1);
    }
}

