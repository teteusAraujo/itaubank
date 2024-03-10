package br.com.itau.itaubank.application.ports.in;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.math.BigDecimal;

public interface TransferUseCase {
    void transfer(String sourceAccountNumber, String targetAccountNumber, BigDecimal amount) throws JsonProcessingException;
}
