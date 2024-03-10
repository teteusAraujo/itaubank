package br.com.itau.itaubank.application.usecase;

import br.com.itau.itaubank.application.ports.in.FindAllMyAccountsUseCase;
import br.com.itau.itaubank.application.ports.out.AccountRepository;
import br.com.itau.itaubank.application.ports.out.CustomerRepository;
import br.com.itau.itaubank.domain.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllMyAccountsUseCaseImpl implements FindAllMyAccountsUseCase {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> execute(Long idCustomer) {
        return accountRepository.getAccountFromCustomer(idCustomer);
    }
}
