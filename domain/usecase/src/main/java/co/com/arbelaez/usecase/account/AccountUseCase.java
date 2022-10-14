package co.com.arbelaez.usecase.account;

import co.com.arbelaez.model.Exception.ErrorException;
import co.com.arbelaez.model.account.Account;
import co.com.arbelaez.model.account.gateways.AccountRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class AccountUseCase {

    private final AccountRepository accountRepository;

    public Account saveAccount(Account account){
        if (account.getAccountNumber() == null){
            account.setAccountNumber(UUID.randomUUID().toString());
        }
        return accountRepository.saveAccount(account);
    }

    public Account deleteAccount(String accountNumber) throws ErrorException {
        return accountRepository.deleteAccount(accountNumber);
    }

    public Account findAccountById(String id){
        return accountRepository.findByAccountNumber(id);
    }
}
