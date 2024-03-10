package br.com.itau.itaubank.application.usecase;


import br.com.itau.itaubank.application.ports.in.CreateAccountUseCase;
import br.com.itau.itaubank.application.ports.out.AccountRepository;
import br.com.itau.itaubank.application.ports.out.CustomerRepository;
import br.com.itau.itaubank.domain.model.Account;
import br.com.itau.itaubank.domain.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateAccountUseCaseImpl implements CreateAccountUseCase {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Account execute(Long idCustomer, Account account) {

        Customer customer = customerRepository.findById(idCustomer).orElse(null);
        if (customer != null) {
            account.setCustomer(customer);
            return repository.create(account);
        }
        return null;
    }
}
