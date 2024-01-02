package tests;

import domain.Account;
import domain.User;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class BalanceTransferTest {

    @Test
    public void testUserBalanceForTransfer() {
        User user = new User();
        Account account = new Account(user);
        account.setBalance(1000.0);

        double transferAmount = 500.0;

        assertTrue("User balance should be greater than transfer amount",
                account.getBalance() > transferAmount);
    }

}

