//package br.com.itau.itaubank.adapter.controller;
//
//import br.com.itau.itaubank.application.ports.in.CreateCustomerUseCase;
//import br.com.itau.itaubank.domain.model.Customer;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
//
//public class CustomerControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private final CreateCustomerUseCase createCustomerUseCase;
//
//    @InjectMocks
//    private CustomerController customerController;
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @BeforeEach
//    void setUp() {
//        mockMvc = standaloneSetup(customerController).build();
//    }
//
//    @Test
//    @DisplayName("Deve criar um cliente caso não tenha um cliente cadastrado com o cpf e email já existente")
//    void createCustomerTest() throws Exception {
//        Customer customer = new Customer(1L, "John Doe", "12345678901", "john.doe@example.com");
//        when(createCustomerUseCase.execute(any())).thenReturn(customer);
//
//        mockMvc.perform(post("/customers")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(customer)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("John Doe"))
//                .andExpect(jsonPath("$.cpf").value("12345678901"))
//                .andExpect(jsonPath("$.email").value("john.doe@example.com"));
//
//        verify(createCustomerUseCase).execute(any());
//    }
//}
