package br.com.itau.itaubank.application.ports.in;

import br.com.itau.itaubank.domain.model.Account;

import java.util.List;

public interface FindAllMyAccountsUseCase {
    List<Account> execute(Long idCustomer);
}
