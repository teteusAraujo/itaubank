package br.com.itau.itaubank.adapter.persistence;

import br.com.itau.itaubank.adapter.persistence.entity.AccountEntity;
import br.com.itau.itaubank.adapter.persistence.repository.AccountJpaRepository;
import br.com.itau.itaubank.adapter.persistence.repository.CustomerJpaRepository;
import br.com.itau.itaubank.application.ports.out.AccountRepository;
import br.com.itau.itaubank.domain.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    AccountJpaRepository accountJpaRepository;

    @Autowired
    CustomerJpaRepository customerRepository;
    @Override
    public Account create(Account account) {
        AccountEntity accountEntity = accountJpaRepository.save(AccountEntity.fromDomain(account));
        return accountEntity.toDomain();
    }

    @Override
    public List<Account> getAccountFromCustomer(Long idCustomer) {

        List<AccountEntity> accountEntities = accountJpaRepository.findAccountsByCustomerId(idCustomer);
        return accountEntities.stream().map(AccountEntity::toDomain).
                collect(Collectors.toList());
    }

    @Override
    public Account findByNumberAccount(String numberAccount) {
        var account = accountJpaRepository.findByNumberAccountIgnoreCase(numberAccount);
        return account.toDomain();
    }

}
