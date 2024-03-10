package br.com.itau.itaubank.application.ports.out;

import br.com.itau.itaubank.domain.model.Transaction;

public interface TransactionRepository {
    Transaction create(Transaction transaction);
}
