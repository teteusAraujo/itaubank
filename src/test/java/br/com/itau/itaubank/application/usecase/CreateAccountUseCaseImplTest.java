//package br.com.itau.itaubank.application.usecase;
//
//import br.com.itau.itaubank.application.ports.out.AccountRepository;
//import br.com.itau.itaubank.application.ports.out.CustomerRepository;
//import br.com.itau.itaubank.domain.enums.AccountType;
//import br.com.itau.itaubank.domain.model.Account;
//import br.com.itau.itaubank.domain.model.Customer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.math.BigDecimal;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//public class CreateAccountUseCaseImplTest {
//    @Mock
//    private AccountRepository accountRepository;
//
//    @Mock
//    private CustomerRepository customerRepository;
//
//    @InjectMocks
//    private CreateAccountUseCaseImpl createAccountUseCase;
//
//    @Test
//    void shouldCreateAccountSuccessFully() throws Exception {
//        Customer customer = new Customer(null, "John Doe", "12345678909", "john@example.com");
//
//        var newCustomer = customerRepository.create(customer);
//        Account account = new Account(
//                null,
//                customer,
//                AccountType.SAVINGS_ACCOUNT,
//                "10203040",
//                BigDecimal.valueOf(70000.0)
//
//        );
//
//        createAccountUseCase.execute(newCustomer.getId(),account);
//        verify(accountRepository).create(any(Account.class));
//    }
//}
