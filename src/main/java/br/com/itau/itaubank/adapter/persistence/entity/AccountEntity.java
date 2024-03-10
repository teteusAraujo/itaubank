package br.com.itau.itaubank.adapter.persistence.entity;

import br.com.itau.itaubank.domain.enums.AccountType;
import br.com.itau.itaubank.domain.model.Account;
import br.com.itau.itaubank.domain.model.Customer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity(name = "account")
@Table(name = "account")
@NoArgsConstructor
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="id_customer", nullable = true)
    private CustomerEntity customer;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private String numberAccount;

    private BigDecimal balance;

    public AccountEntity(Long id, CustomerEntity customer, AccountType accountType, String numberAccount, BigDecimal balance) {
        this.id = id;
        this.customer = customer;
        this.accountType = accountType;
        this.numberAccount = numberAccount;
        this.balance = balance;
    }

    public static AccountEntity fromDomain(Account account){
        return new AccountEntity(
               account.getId(),
               CustomerEntity.fromDomain(account.getCustomer()),
               account.getAccountType(),
               account.getNumberAccount(),
               account.getBalance()
        );
    }

    public Account toDomain() {
        return new Account(
                this.getId(),
                this.getCustomer().toDomain(),
                this.getAccountType(),
                this.getNumberAccount(),
                this.getBalance()
        );
    }
}
