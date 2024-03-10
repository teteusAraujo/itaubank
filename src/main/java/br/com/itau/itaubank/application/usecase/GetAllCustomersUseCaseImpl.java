package br.com.itau.itaubank.application.usecase;

import br.com.itau.itaubank.application.ports.in.GetAllCustomersUseCase;
import br.com.itau.itaubank.application.ports.out.CustomerRepository;
import br.com.itau.itaubank.domain.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCustomersUseCaseImpl implements GetAllCustomersUseCase {

    @Autowired
    CustomerRepository repository;
    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }
}
