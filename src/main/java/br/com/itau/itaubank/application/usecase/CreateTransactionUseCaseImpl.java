package br.com.itau.itaubank.application.usecase;

import br.com.itau.itaubank.application.ports.in.CreateTransactionUseCase;
import br.com.itau.itaubank.application.ports.out.TransactionRepository;
import br.com.itau.itaubank.domain.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    @Autowired
    private TransactionRepository repository;

    @Override
    public Transaction execute(Transaction transaction) {
        return repository.create(transaction);
    }
}
