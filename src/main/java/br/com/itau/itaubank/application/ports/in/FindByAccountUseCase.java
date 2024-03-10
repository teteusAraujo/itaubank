package br.com.itau.itaubank.application.ports.in;

import br.com.itau.itaubank.domain.model.Customer;

import java.util.Optional;

public interface FindByAccountUseCase {

    Optional<Customer> execute(Long id);
}
