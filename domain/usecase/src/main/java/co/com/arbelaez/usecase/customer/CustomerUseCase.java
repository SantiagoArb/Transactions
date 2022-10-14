package co.com.arbelaez.usecase.customer;

import co.com.arbelaez.model.Exception.ErrorException;
import co.com.arbelaez.model.customer.Customer;
import co.com.arbelaez.model.customer.gateways.CustomerRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class CustomerUseCase {

    private final CustomerRepository customerRepository;

    public Customer saveCustomer(Customer cliente){
        return customerRepository.saveCustomer(cliente);
    }

    public Customer deleteCustomer(String identification) throws ErrorException {
        return customerRepository.deleteCustomer(identification);
    }
}
