package br.com.itau.itaubank.adapter.persistence.repository;

import br.com.itau.itaubank.adapter.persistence.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {
    List<AccountEntity> findAccountsByCustomerId(Long idCustomer);

    AccountEntity findByNumberAccountIgnoreCase(String numberAccount);
}
