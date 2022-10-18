package co.com.arbelaez.api.customer;
import co.com.arbelaez.api.utils.SuccessResponse;
import co.com.arbelaez.model.Exception.ErrorException;
import co.com.arbelaez.model.customer.Customer;
import co.com.arbelaez.usecase.customer.CustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/customer", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRestCustomers {

    private static final String SUCCESS_MESSAGE = "Operacion Exitosa";
    private static final String ERROR_MESSAGE = "Operacion Fallida";
    private final CustomerUseCase useCase;


    @GetMapping(path = "/health")
    public String health() {
        return "Application is UP!!!";
    }

    @PostMapping()
    public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer){
       try{
           return ResponseEntity.ok(SuccessResponse.success("Customer", useCase.saveCustomer(customer),SUCCESS_MESSAGE));
       }catch (Exception ex){
           return ResponseEntity.ok(SuccessResponse.error(ex.getMessage() != null? ex.getMessage(): ex.getCause().getMessage(),500));
       }

    }

    @PutMapping()
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer){
        try{
            return ResponseEntity.ok(SuccessResponse.success("Customer", useCase.updateCustomer(customer),SUCCESS_MESSAGE));
        }catch (Exception ex){
            return ResponseEntity.ok(SuccessResponse.error(ex.getMessage() != null? ex.getMessage(): ex.getCause().getMessage(),500));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable String id) throws ErrorException {
        try
        {
            return ResponseEntity.ok(SuccessResponse.success("Delete", useCase.deleteCustomer(id),SUCCESS_MESSAGE));
        }catch (ErrorException ex){
            return ResponseEntity.ok(SuccessResponse.error(ex.getMessage() != null? ex.getMessage(): ex.getCause().getMessage(),ex.getCode()));
        }

    }
}
