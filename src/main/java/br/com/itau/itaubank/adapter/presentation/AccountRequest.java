package br.com.itau.itaubank.adapter.presentation;

import br.com.itau.itaubank.domain.model.Account;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {

    @NotBlank(message = "{campo.idCustomer.obrigatorio}")
    private Long idCustomer;

    @NotBlank(message = "{campo.accountType.obrigatorio}")
    @Schema(description = "Tipo de conta (apenas poupanca ou corrente)", example = "SAVINGS_ACCOUNT")
    private AccountTypeDTO accountType;

    @NotBlank(message = "{campo.numberAccount.obrigatorio}")
    @Schema(description = "Numero da conta contendo uma string de 8 numeros", example = "02973945")
    private String numberAccount;

    @NotBlank(message = "{campo.balance.obrigatorio}")
    private BigDecimal balance;

    public Account toUserDomain() {
        return new Account(
                accountType,
                numberAccount,
                balance
        );
    }
}
