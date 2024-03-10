package br.com.itau.itaubank.adapter.persistence;

import br.com.itau.itaubank.adapter.persistence.entity.TransactionEntity;
import br.com.itau.itaubank.adapter.persistence.repository.TransactionJpaRepository;
import br.com.itau.itaubank.application.ports.out.TransactionRepository;
import br.com.itau.itaubank.domain.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionRepositoryImpl implements TransactionRepository {

    @Autowired
    private TransactionJpaRepository repository;

    @Override
    public Transaction create(Transaction transaction) {
        TransactionEntity entity = repository.save(TransactionEntity.fromDomain(transaction));
        return entity.toDomain();
    }
}
