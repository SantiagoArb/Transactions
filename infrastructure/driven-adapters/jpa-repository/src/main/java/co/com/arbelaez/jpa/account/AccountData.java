package co.com.arbelaez.jpa.account;

import co.com.arbelaez.jpa.customer.CustomerData;
import co.com.arbelaez.model.account.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "account")
public class AccountData {
    @Id
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "account_type")
    private String AccountType;
    @Column(name = "initial_balance")
    private BigDecimal initialBalance;
    private boolean state;
    @Column(name = "id_customer")
    private String idCustomer;
}
