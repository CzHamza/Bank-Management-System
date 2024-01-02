package domain;

import java.util.HashMap;
import java.util.Map;

public class DB {
    private Map<Long, Account> accountMap;

    public DB() {
        this.accountMap = new HashMap<>();
    }

    public void saveAccount(Account account) {
        accountMap.put(account.getId(), account);
    }

    public Account getAccountById(Long id) {
        return accountMap.get(id);
    }
}

