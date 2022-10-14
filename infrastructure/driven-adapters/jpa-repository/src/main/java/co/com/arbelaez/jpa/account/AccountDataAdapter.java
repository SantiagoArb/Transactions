package co.com.arbelaez.jpa.account;

import co.com.arbelaez.jpa.helper.AdapterOperations;
import co.com.arbelaez.model.Exception.ErrorException;
import co.com.arbelaez.model.account.Account;
import co.com.arbelaez.model.account.gateways.AccountRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDataAdapter extends AdapterOperations<Account, AccountData, String, AccountDataRepository> implements AccountRepository {

    @Autowired
    public AccountDataAdapter(AccountDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d-> mapper.mapBuilder(d, Account.AccountBuilder.class).build());
    }

    @Override
    public Account saveAccount(Account account){
        return super.save(account);
    }

    @Override
    public Account deleteAccount(String accountNumber) throws ErrorException {
        Account account = findByAccountNumber(accountNumber);
        if(account != null){
            repository.deleteById(accountNumber);
            return account;
        }
        throw new ErrorException("No se el numero de cuenta",404);

    }

    @Override
    public Account findByAccountNumber(String id) {
        return super.findById(id);
    }
}
