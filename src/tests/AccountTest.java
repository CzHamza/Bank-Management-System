package tests;

import static org.junit.Assert.*;

import domain.Account;
import domain.Transaction;
import org.junit.*;

import java.time.LocalDate;
import java.util.List;

public class AccountTest {

    private Account account;
    private Account anotherAccount;

    @Before
    public void setUp() {
        account = new Account();
        account.setId(1L);
        account.setBalance(1000.0);

        anotherAccount = new Account();
        anotherAccount.setId(2L);
        anotherAccount.setBalance(500.0);
    }

    @Test
    public void testDeposit() {
        double initialBalance = account.getBalance();
        double depositAmount = 500.0;

        boolean depositResult = account.deposit(depositAmount, anotherAccount);

        assertTrue(depositResult);
        assertEquals(initialBalance + depositAmount, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawal() {
        double initialBalance = account.getBalance();
        double withdrawAmount = 300.0;

        boolean withdrawResult = account.withdraw(withdrawAmount);

        assertTrue(withdrawResult);
        assertEquals(initialBalance - withdrawAmount, account.getBalance(), 0.001);
    }


    @Test
    public void testTransfer() {
        double senderInitialBalance = account.getBalance();
        double receiverInitialBalance = anotherAccount.getBalance();
        double transferAmount = 200.0;

        boolean transferResult = account.transfer(transferAmount, anotherAccount, LocalDate.now());

        assertTrue(transferResult);
        assertEquals(senderInitialBalance - transferAmount, account.getBalance(), 0.001);
        assertEquals(receiverInitialBalance + transferAmount, anotherAccount.getBalance(), 0.001);
    }

    @Test
    public void testShowHistory() {
        List<Transaction> transactionList = account.showHistory();

        assertNotNull(transactionList);
    }
}
