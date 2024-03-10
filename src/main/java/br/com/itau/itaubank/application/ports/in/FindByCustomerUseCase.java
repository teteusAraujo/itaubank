package br.com.itau.itaubank.application.ports.in;

import br.com.itau.itaubank.domain.model.Customer;

import java.util.Optional;

public interface FindByCustomerUseCase {

    Optional<Customer> execute(Long id);
}
