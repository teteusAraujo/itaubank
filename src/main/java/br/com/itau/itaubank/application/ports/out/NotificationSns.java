package br.com.itau.itaubank.application.ports.out;

import br.com.itau.itaubank.domain.model.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface NotificationSns {

    void execute(Transaction transaction);
}
