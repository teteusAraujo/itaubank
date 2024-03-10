package br.com.itau.itaubank.application.ports.in;

import br.com.itau.itaubank.domain.model.Customer;

public interface UpdateCustomerUseCase {

    Customer execute(Long id , Customer customer);
}
