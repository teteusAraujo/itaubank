package br.com.itau.itaubank.adapter.presentation;

import br.com.itau.itaubank.domain.model.Transaction;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    @NotBlank(message = "campo.amount.obrigatorio")
    private BigDecimal amount;

    @NotBlank(message = "{campo.sourceAccountNumber.obrigatorio}")
    @Schema(description = "Numero da conta que envia a transferencia contendo uma string de 8 numeros", example = "02973945")
    private String sourceAccountNumber;

    @NotBlank(message = "{campo.targetAccountNumber.obrigatorio}")
    @Schema(description = "Numero da conta que recebe a transferencia contendo uma string de 8 numeros", example = "02973945")
    private String targetAccountNumber;
}
