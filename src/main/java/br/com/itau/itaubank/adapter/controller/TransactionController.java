package br.com.itau.itaubank.adapter.controller;

import br.com.itau.itaubank.adapter.presentation.TransactionRequest;
import br.com.itau.itaubank.adapter.presentation.TransactionResponse;
import br.com.itau.itaubank.application.ports.in.TransferUseCase;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/transfer")
public class TransactionController {
    private final TransferUseCase transferUseCase;

    public TransactionController(TransferUseCase transferUseCase){
        this.transferUseCase = transferUseCase;
    }
    @PostMapping()
    @Operation(summary = "Faz a tranferencia de dinheiro de uma conta para outra", description = "Retorna o status da conta se foi realizada com sucesso ou se ocorreu um erro ao processar a transferência")
    public ResponseEntity<?> transferFunds(@RequestBody TransactionRequest transactionRequest) {
        try {
            transferUseCase.transfer(transactionRequest.getSourceAccountNumber(), transactionRequest.getTargetAccountNumber(), transactionRequest.getAmount());
            return ResponseEntity.ok(new TransactionResponse("Transferência realizada com sucesso."));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new TransactionResponse("Ocorreu um erro ao processar a transferência."));
        }
    }
}
