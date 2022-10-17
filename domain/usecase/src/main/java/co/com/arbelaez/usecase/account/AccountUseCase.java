package co.com.arbelaez.usecase.account;

import co.com.arbelaez.model.Exception.ErrorException;
import co.com.arbelaez.model.account.Account;
import co.com.arbelaez.model.account.gateways.AccountRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class AccountUseCase {

    private final AccountRepository accountRepository;

    public Account createAccount(Account account) throws ErrorException {
        if (account.getAccountNumber() != null && findAccountById(account.getAccountNumber()) != null){
            throw new ErrorException("El numero de cuenta ya existe",500);
        }
        account.setAccountNumber(UUID.randomUUID().toString());
        return accountRepository.saveAccount(account);
    }

    public Account updateAccount(Account account) throws ErrorException {
        if (account.getAccountNumber() != null){
            if(findAccountById(account.getAccountNumber()) != null){
                return accountRepository.saveAccount(account);

            }else{
                throw new ErrorException("La cuenta no existe",500);
            }

        }else{
            throw new ErrorException("Numero de cuenta no valido",500);
        }

    }

    public Account deleteAccount(String accountNumber) throws ErrorException {
        return accountRepository.deleteAccount(accountNumber);
    }

    public Account findAccountById(String id){
        return accountRepository.findByAccountNumber(id);
    }
}
