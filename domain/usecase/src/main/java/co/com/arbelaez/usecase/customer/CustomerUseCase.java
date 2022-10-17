package co.com.arbelaez.usecase.customer;

import co.com.arbelaez.model.Exception.ErrorException;
import co.com.arbelaez.model.customer.Customer;
import co.com.arbelaez.model.customer.gateways.CustomerRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class CustomerUseCase {

    private final CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) throws ErrorException {
        if (customer.getIdentification() != null && findCustomerById(customer.getIdentification()) != null) {
            throw new ErrorException("Ya existe un cliente con esa identificacion",500);
        }
        return customerRepository.saveCustomer(customer);
    }

    public Customer updateCustomer(Customer customer) throws ErrorException {
        if (customer.getIdentification() != null) {
           if (findCustomerById(customer.getIdentification())!=null){
               return customerRepository.saveCustomer(customer);
           }else {
               throw new ErrorException("El cliente no existe",500);
           }
        }else {
            throw new ErrorException("Numero de identificacion no valido",500);
        }

    }

    public Customer deleteCustomer(String identification) throws ErrorException {
        return customerRepository.deleteCustomer(identification);
    }

    public Customer findCustomerById(String id){
        return customerRepository.findByIdentification(id);
    }
}
