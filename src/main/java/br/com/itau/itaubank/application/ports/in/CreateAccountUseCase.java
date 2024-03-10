package br.com.itau.itaubank.application.ports.in;

import br.com.itau.itaubank.domain.model.Account;

public interface CreateAccountUseCase {

    Account execute(Long idCustomer, Account account);
}
