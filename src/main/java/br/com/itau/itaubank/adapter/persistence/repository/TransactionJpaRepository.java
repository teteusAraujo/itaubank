package br.com.itau.itaubank.adapter.persistence.repository;

import br.com.itau.itaubank.adapter.persistence.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, Long> {
}
