package br.com.itau.itaubank.application.usecase;

import br.com.itau.itaubank.application.ports.in.UpdateCustomerUseCase;
import br.com.itau.itaubank.application.ports.out.CustomerRepository;
import br.com.itau.itaubank.domain.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer execute(Long id, Customer customer) {
      return customerRepository.update(id, customer);
    }
}
