package br.com.itau.itaubank.application.usecase;

import br.com.itau.itaubank.application.ports.in.DeleteCustomerUseCase;
import br.com.itau.itaubank.application.ports.out.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

    @Autowired
    CustomerRepository repository;

    @Override
    public void execute(Long id) {
        repository.delete(id);
    }
}
