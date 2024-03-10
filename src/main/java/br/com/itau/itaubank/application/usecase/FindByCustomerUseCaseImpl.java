package br.com.itau.itaubank.application.usecase;

import br.com.itau.itaubank.application.ports.in.FindByCustomerUseCase;
import br.com.itau.itaubank.application.ports.out.CustomerRepository;
import br.com.itau.itaubank.domain.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindByCustomerUseCaseImpl implements FindByCustomerUseCase {

    @Autowired
    CustomerRepository repository;

    @Override
    public Optional<Customer> execute(Long id) {

        return repository.findById(id);
    }
}
