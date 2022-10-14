package co.com.arbelaez.model.account.gateways;

import co.com.arbelaez.model.Exception.ErrorException;
import co.com.arbelaez.model.account.Account;

public interface AccountRepository {
    Account saveAccount(Account account);
    Account findByAccountNumber(String id);
    Account deleteAccount(String accountNumber) throws ErrorException;
}
