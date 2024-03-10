//package br.com.itau.itaubank.application.usecase;
//
//import br.com.itau.itaubank.application.ports.out.CustomerRepository;
//import br.com.itau.itaubank.domain.model.Customer;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//
//@ExtendWith(MockitoExtension.class)
//public class UpdateCustomerUseCaseImplTest {
//
//    @Mock
//    private CustomerRepository customerRepository;
//
//    @InjectMocks
//    private UpdateCustomerUseCaseImpl updateCustomerUseCase;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void shouldUpdateCustomerSuccessfully() throws Exception {
//        Customer existingCustomer = new Customer(1L, "Name", "06104642307", "email@example.com");
//        customerRepository.create(existingCustomer);
//        Customer updatedCustomer = new Customer(1L, "Updated Name", "06104642307", "email@example.com");
//
//
//        when(customerRepository.findById(1L)).thenReturn(Optional.of(existingCustomer));
//        when(customerRepository.create(any(Customer.class))).thenReturn(updatedCustomer);
//
//
//        Customer result = updateCustomerUseCase.execute(1L, updatedCustomer);
//
//        // Verificações e asserções
//        verify(customerRepository, times(1)).findById(1L);
//        verify(customerRepository, times(1)).create(any(Customer.class));
//        assertEquals("Updated Name", result.getName());
//    }
//}
//
