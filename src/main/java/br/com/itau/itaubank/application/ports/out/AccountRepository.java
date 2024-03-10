package br.com.itau.itaubank.application.ports.out;

import br.com.itau.itaubank.domain.model.Account;

import java.util.List;

public interface AccountRepository {

    Account create(Account account);

    List<Account> getAccountFromCustomer(Long idCustomer);

    Account findByNumberAccount(String numberAccount);
}
