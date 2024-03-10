package br.com.itau.itaubank.application.ports.in;

import br.com.itau.itaubank.domain.model.Transaction;

public interface CreateTransactionUseCase {

    Transaction execute(Transaction transaction);
}
