package co.com.arbelaez.model.customer.gateways;

import co.com.arbelaez.model.Exception.ErrorException;
import co.com.arbelaez.model.customer.Customer;

public interface CustomerRepository {

    Customer saveCustomer(Customer customer);
    Customer deleteCustomer(String identification) throws ErrorException;
    Customer findByIdentification(String id);
}
