package co.com.arbelaez.api.accounts;

import co.com.arbelaez.model.account.Account;
import co.com.arbelaez.model.account.AccountType;
import co.com.arbelaez.model.account.gateways.AccountRepository;
import co.com.arbelaez.usecase.account.AccountUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.math.BigDecimal;
import java.util.Locale;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {co.com.arbelaez.usecase.account.AccountUseCase.class, co.com.arbelaez.model.account.gateways.AccountRepository.class, co.com.arbelaez.api.accounts.ApiRestAccounts.class} )
@AutoConfigureMockMvc
@EnableWebMvc
class ApiRestAccountsTest {

        @Autowired
        private MockMvc mvc;

        @MockBean
        private AccountRepository accountRepository;

        @MockBean
        private AccountUseCase accountUseCase;

        @Test
        void saveAccount() throws Exception {
            MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
            String json = "{\"accountType\": \"AHORROS\",\"initialBalance\": 11000,\"state\": true,\"idCustomer\": \"151515\"}";
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/accounts");
            request.content(json);
            request.locale(Locale.ENGLISH);
            request.accept(MEDIA_TYPE_JSON_UTF8);
            request.contentType(MEDIA_TYPE_JSON_UTF8);


            Account account = Account.builder().accountNumber("1515").accountType(AccountType.AHORROS).idCustomer("151515").initialBalance(BigDecimal.valueOf(11000)).state(true).build();
            Mockito.when(accountUseCase.createAccount(account)).thenReturn(account);
            Mockito.when(accountRepository.findByAccountNumber(Mockito.any())).thenReturn(account);
            mvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MEDIA_TYPE_JSON_UTF8));
        }

        @Test
        void updateAccount() throws Exception {
            MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
            String json = "{\"accountNumber\":\"08077e9e-a265-479d-abdc-7f6870159c03\",\"accountType\": \"AHORROS\",\"initialBalance\": 11000,\"state\": true,\"idCustomer\": \"151515\"}";
            Account account = Account.builder().accountNumber("1515").accountType(AccountType.AHORROS).idCustomer("151515").initialBalance(BigDecimal.valueOf(11000)).state(true).build();
           // Mockito.when(accountUseCase.createAccount(account)).thenReturn(account);
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/api/v1/accounts");
            request.content(json);
            request.locale(Locale.ENGLISH);
            request.accept(MEDIA_TYPE_JSON_UTF8);
            request.contentType(MEDIA_TYPE_JSON_UTF8);
            Mockito.when(accountRepository.saveAccount(account)).thenReturn(account);
            Mockito.when(accountRepository.findByAccountNumber(Mockito.any())).thenReturn(account);
            mvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MEDIA_TYPE_JSON_UTF8));;
        }
    }