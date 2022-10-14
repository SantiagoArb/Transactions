package co.com.arbelaez.jpa.account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface AccountDataRepository extends CrudRepository<AccountData, String>, QueryByExampleExecutor<AccountData> {
}
