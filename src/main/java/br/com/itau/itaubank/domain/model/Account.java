package br.com.itau.itaubank.domain.model;

import br.com.itau.itaubank.adapter.presentation.AccountTypeDTO;
import br.com.itau.itaubank.domain.enums.AccountType;

import java.math.BigDecimal;
import java.util.Optional;

public class Account {
    private Long id;
    private Customer customer;
    private AccountType accountType;
    private String numberAccount;
    private BigDecimal balance;

    public Account(){

    }

    public Account(Long id, Customer customer, AccountType accountType, String numberAccount, BigDecimal balance) {
        this.id = id;
        this.customer = customer;
        this.accountType = accountType;
        this.numberAccount = numberAccount;
        this.balance = balance;
    }

    public Account(Customer customer, AccountTypeDTO accountType, String numberAccount, BigDecimal balance) {
        this.customer = customer;
        this.accountType = accountType.toDomain();
        this.numberAccount = numberAccount;
        this.balance = balance;
    }

    public Account(AccountTypeDTO accountType, String numberAccount, BigDecimal balance) {
        this.accountType = accountType.toDomain();
        this.numberAccount = numberAccount;
        this.balance = balance;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
