package br.com.itau.itaubank.adapter.persistence.repository;

import br.com.itau.itaubank.adapter.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {

    boolean existsByEmailOrCpf(String email, String cpf);
}
