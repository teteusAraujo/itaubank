//package br.com.itau.itaubank.application.usecase;
//
//import br.com.itau.itaubank.application.ports.in.CreateCustomerUseCase;
//import br.com.itau.itaubank.application.ports.out.CustomerRepository;
//import br.com.itau.itaubank.domain.model.Customer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import static org.mockito.Mockito.verify;
//import static org.mockito.ArgumentMatchers.any;
//
//
//@ExtendWith(MockitoExtension.class)
//public class CreateCustomerUseCaseImplTest {
//
//    @Mock
//    private CustomerRepository customerRepository;
//
//    @InjectMocks
//    private CreateCustomerUseCaseImpl createCustomerUseCase;
//
//    @Test
//    void shouldCreateCustomerSuccessfully() throws Exception {
//        Customer customer = new Customer(null, "John Doe", "12345678909", "john@example.com");
//
//        createCustomerUseCase.execute(customer);
//
//        verify(customerRepository).create(any(Customer.class));
//    }
//}
