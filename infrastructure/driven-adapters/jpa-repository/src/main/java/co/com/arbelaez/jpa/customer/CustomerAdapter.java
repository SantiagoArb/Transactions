package co.com.arbelaez.jpa.customer;

import co.com.arbelaez.jpa.helper.AdapterOperations;
import co.com.arbelaez.model.Exception.ErrorException;
import co.com.arbelaez.model.customer.Customer;
import co.com.arbelaez.model.customer.gateways.CustomerRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerAdapter extends AdapterOperations<Customer, CustomerData, String, CustomerDataRepository> implements CustomerRepository {

    @Autowired
    public CustomerAdapter(CustomerDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d-> mapper.mapBuilder(d, Customer.CustomerBuilder.class).build());
    }

    @Override
    public Customer saveCustomer(Customer customer){
        return super.save(customer);
    }

    @Override
    public Customer deleteCustomer(String identification) throws ErrorException {
        Customer customer = findByIdentification(identification);
        if(customer != null){
          repository.deleteById(identification);
          return customer;
        }
        throw new ErrorException("No se encontro la persona",404);

    }

    @Override
    public Customer findByIdentification(String id) {
        return super.findById(id);
    }
}
