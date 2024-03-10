package br.com.itau.itaubank.adapter.presentation;

import br.com.itau.itaubank.domain.enums.AccountType;
import br.com.itau.itaubank.domain.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

    private Long id;
    private String name;
    private String cpf;
    private String email;

    public CustomerResponse(Long id, Customer customer, AccountType accountType, String numberAccount, BigDecimal balance) {
    }

    public static CustomerResponse fromDomain(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getCpf(),
                customer.getEmail()
        );
    }

}
