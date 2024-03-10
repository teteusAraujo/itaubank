package br.com.itau.itaubank.application.ports.in;

import br.com.itau.itaubank.domain.model.Customer;

import java.util.List;

public interface GetAllCustomersUseCase {

    List<Customer> getAll() ;
}
