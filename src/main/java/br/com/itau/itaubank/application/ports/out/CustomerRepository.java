package br.com.itau.itaubank.application.ports.out;

import br.com.itau.itaubank.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    Customer create(Customer customer);

    Optional<Customer> findById(Long id);

    List<Customer> findAll();

    Customer update(Long id ,Customer customer);

    void delete(Long id);
}
