package co.com.arbelaez.api.accounts;

import co.com.arbelaez.model.account.Account;
import co.com.arbelaez.model.account.AccountType;
import co.com.arbelaez.model.account.gateways.AccountRepository;
import co.com.arbelaez.usecase.account.AccountUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

@ContextConfiguration(classes ={co.com.arbelaez.usecase.account.AccountUseCase.class, co.com.arbelaez.model.account.gateways.AccountRepository.class} )
@WebMvcTest(controllers = ApiRestAccounts.class)
class ApiRestAccountsTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountUseCase accountUseCase;



    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveAccount() throws Exception {

        String json = "{\"accountType\": \"AHORROS\",\"initialBalance\": 11000,\"state\": true,\"idCustomer\": \"151515\"}";
        Account account = Account.builder().accountNumber("1515").accountType(AccountType.AHORROS).idCustomer("151515").initialBalance(BigDecimal.valueOf(11000)).state(true).build();
        Mockito.when(accountUseCase.createAccount(Mockito.any())).thenReturn(account);
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/accounts")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void deleteAccount() {
    }
}