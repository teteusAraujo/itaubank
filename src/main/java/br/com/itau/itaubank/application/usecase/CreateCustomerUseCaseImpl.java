package br.com.itau.itaubank.application.usecase;

import br.com.itau.itaubank.application.ports.in.CreateCustomerUseCase;
import br.com.itau.itaubank.application.ports.out.CustomerRepository;
import br.com.itau.itaubank.domain.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    @Autowired
    CustomerRepository repository;

    @Override
    public Customer execute(Customer customer) {
        return repository.create(customer);
    }
}
