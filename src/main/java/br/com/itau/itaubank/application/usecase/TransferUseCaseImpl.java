package br.com.itau.itaubank.application.usecase;

import br.com.itau.itaubank.application.ports.in.TransferUseCase;
import br.com.itau.itaubank.application.ports.out.AccountRepository;
import br.com.itau.itaubank.application.ports.out.NotificationSns;
import br.com.itau.itaubank.application.ports.out.TransactionRepository;
import br.com.itau.itaubank.domain.model.Account;
import br.com.itau.itaubank.domain.model.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransferUseCaseImpl implements TransferUseCase {

    private final AccountRepository accountRepository;

    private final TransactionRepository transactionRepository;

    private  final NotificationSns notificationSns;

    public TransferUseCaseImpl(AccountRepository accountRepository,
                               TransactionRepository transactionRepository,
                               NotificationSns notificationSns){
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.notificationSns = notificationSns;
    }

    @Override
    @Transactional
    public void transfer(String sourceAccountNumber, String targetAccountNumber, BigDecimal amount) throws JsonProcessingException {
        Account sourceAccount = accountRepository.findByNumberAccount(sourceAccountNumber);
        Account targetAccount = accountRepository.findByNumberAccount(targetAccountNumber);

        validateTransaction(sourceAccount, amount);
        // TODO: sourceAccount.withdraw(amount); Num futuro crio as use case para saque em vez de usar os getrs e seters
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));

        // TODO: targetAccount.deposit(amount); Num fututo crio a use case para deposito em vez de usar os geters e sters
        targetAccount.setBalance(targetAccount.getBalance().add(amount));


        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(amount);
        newTransaction.setSender(sourceAccount);
        newTransaction.setReceiver(targetAccount);
        newTransaction.setTimestamp(LocalDateTime.now());

        transactionRepository.create(newTransaction);
        accountRepository.create(sourceAccount);
        accountRepository.create(targetAccount);

        notificationSns.execute(newTransaction);
    }

    public void validateTransaction( Account  sourceAccount, BigDecimal amount ){
        if (sourceAccount.getBalance().compareTo(amount)<0){
            throw new RuntimeException("Saldo insuficiente");
        }
    }

}
