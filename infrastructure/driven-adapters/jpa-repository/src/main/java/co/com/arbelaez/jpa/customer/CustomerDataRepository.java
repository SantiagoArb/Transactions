package co.com.arbelaez.jpa.customer;

import co.com.arbelaez.model.customer.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

public interface CustomerDataRepository extends CrudRepository<CustomerData, String>, QueryByExampleExecutor<CustomerData> {
}
