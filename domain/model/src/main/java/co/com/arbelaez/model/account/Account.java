package co.com.arbelaez.model.account;
import co.com.arbelaez.model.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class Account {
    private String accountNumber;
    private AccountType accountType;
    private BigDecimal initialBalance;
    private boolean state;
    private String idCustomer;
}
