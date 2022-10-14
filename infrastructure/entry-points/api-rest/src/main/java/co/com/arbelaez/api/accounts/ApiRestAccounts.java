package co.com.arbelaez.api.accounts;

import co.com.arbelaez.api.utils.SuccessResponse;
import co.com.arbelaez.model.Exception.ErrorException;
import co.com.arbelaez.model.account.Account;
import co.com.arbelaez.model.account.AccountType;
import co.com.arbelaez.model.customer.Customer;
import co.com.arbelaez.usecase.account.AccountUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRestAccounts {
    private static final String SUCCESS_MESSAGE = "Operacion Exitosa";
    private static final String ERROR_MESSAGE = "Operacion Fallida";

    private final AccountUseCase accountUseCase;


    @PostMapping()
    public ResponseEntity<Object> saveAccount(@RequestBody Account account){
        try{
            return ResponseEntity.ok(SuccessResponse.success("Account", accountUseCase.saveAccount(account),SUCCESS_MESSAGE));
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.ok(SuccessResponse.error(ex.getMessage() != null? ex.getMessage(): ex.getCause().getMessage(),500));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAccount(@PathVariable String id) throws ErrorException {
        try
        {
            return ResponseEntity.ok(SuccessResponse.success("Delete", accountUseCase.deleteAccount(id),SUCCESS_MESSAGE));
        }catch (ErrorException ex){
            return ResponseEntity.ok(SuccessResponse.error(ex.getMessage(),ex.getCode()));
        }

    }
}
