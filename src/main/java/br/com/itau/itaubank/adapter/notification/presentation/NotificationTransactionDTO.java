package br.com.itau.itaubank.adapter.notification.presentation;

import br.com.itau.itaubank.domain.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationTransactionDTO {
    private BigDecimal amount;
    private String sourceAccountNumber;
    private String targetAccountNumber;


    public static NotificationTransactionDTO fromDomain(Transaction transaction){
        return new NotificationTransactionDTO(
                transaction.getAmount(),
                transaction.getSender().getNumberAccount(),
                transaction.getReceiver().getNumberAccount()
        );
    }
}
