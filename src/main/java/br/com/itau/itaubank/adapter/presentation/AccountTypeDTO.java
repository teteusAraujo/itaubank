package br.com.itau.itaubank.adapter.presentation;

import br.com.itau.itaubank.domain.enums.AccountType;

public enum AccountTypeDTO {
    SAVINGS_ACCOUNT {
        @Override
        public AccountType toDomain() {
           return AccountType.SAVINGS_ACCOUNT;
        }

    },
    CHECKING_ACCOUNT {
        @Override
        public AccountType toDomain() {
            return AccountType.CHECKING_ACCOUNT;
        }

    };

    public abstract AccountType toDomain();
    public static AccountTypeDTO fromDomain(AccountType accountType){
        return AccountTypeDTO.valueOf(accountType.name());
    }
}
