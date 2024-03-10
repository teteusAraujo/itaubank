package br.com.itau.itaubank.adapter.persistence.entity;

import br.com.itau.itaubank.domain.model.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transaction")
@Table(name = "transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private AccountEntity sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private AccountEntity receiver;

    private LocalDateTime timestamp;

    public static TransactionEntity fromDomain(Transaction transaction){
        return new TransactionEntity(
                transaction.getId(),
                transaction.getAmount(),
                AccountEntity.fromDomain(transaction.getSender()),
                AccountEntity.fromDomain(transaction.getReceiver()),
                transaction.getTimestamp()
        );
    }

    public Transaction toDomain(){
        return new Transaction(
                this.getId(),
                this.getAmount(),
                this.getSender().toDomain(),
                this.getReceiver().toDomain(),
                this.getTimestamp()
        );
    }
}
