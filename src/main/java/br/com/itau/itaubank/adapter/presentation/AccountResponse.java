package br.com.itau.itaubank.adapter.presentation;

import br.com.itau.itaubank.domain.model.Account;
import br.com.itau.itaubank.domain.model.Customer;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountResponse {
    private Long id;
    private Customer customer;
    private AccountTypeDTO accountType;
    private String numberAccount;
    private BigDecimal balance;


    public AccountResponse(Long id, Customer customer, AccountTypeDTO accountType, String numberAccount, BigDecimal balance) {
        this.id = id;
        this.customer = customer;
        this.accountType = accountType;
        this.numberAccount = numberAccount;
        this.balance = balance;
    }

    public static AccountResponse fromDomain(Account account) {
        return new AccountResponse(
                account.getId(),
                account.getCustomer(),
                AccountTypeDTO.fromDomain(account.getAccountType()),
                account.getNumberAccount(),
                account.getBalance()
        );
    }
}
