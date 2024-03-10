package br.com.itau.itaubank.adapter.controller;

import br.com.itau.itaubank.adapter.presentation.CustomerRequest;
import br.com.itau.itaubank.adapter.presentation.CustomerResponse;
import br.com.itau.itaubank.application.ports.in.*;
import br.com.itau.itaubank.domain.model.Account;
import br.com.itau.itaubank.domain.model.Customer;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final FindByCustomerUseCase findByCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final GetAllCustomersUseCase getAllCustomersUseCase;
    private final FindAllMyAccountsUseCase findAllMyAccountsUseCase;

    @GetMapping("/{id}")
    @Operation(summary = "Busca um cliente pelo o id", description = "Id exemplo 1")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Optional<Customer> customer = findByCustomerUseCase.execute(id);
        return customer.map(value -> ResponseEntity.ok().body(value))
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{idCustomer}/accounts")
    @Operation(summary = "Lista as contas de um cliente", description = "Id exemplo 10 ")
    public ResponseEntity<List<Account>> getCustomerAccounts(@PathVariable Long idCustomer) {
        List<Account> accounts = findAllMyAccountsUseCase.execute(idCustomer);
        if (!accounts.isEmpty()) {
            return ResponseEntity.ok(accounts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary = "Lista todos os clientes cadastrado de forma paginada",
            description = "O tamanho default é de 20 registros por página, ordenados pelo id")
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> customers = getAllCustomersUseCase.getAll();
        return ResponseEntity.ok(customers);
    }

    @PostMapping()
    @Operation(summary = "Cadastra um novo cliente", description = "Retorna o cliente salvo no Body com o seu Id")
    public ResponseEntity<CustomerResponse> create(@RequestBody CustomerRequest customerRequest){
        var domain = customerRequest.toUserDomain();
        return ResponseEntity.ok(CustomerResponse.fromDomain(
                createCustomerUseCase.execute(domain)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um cliente cadastrado", description = "Retorna o cliente atualizado e salvo no Body")
    public ResponseEntity<CustomerResponse> update(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        Customer updatedCustomer = updateCustomerUseCase.execute(id, customerRequest.toUserDomain());
        if (updatedCustomer != null) {
            return ResponseEntity.ok(CustomerResponse.fromDomain(updatedCustomer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um cliente cadastrado")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        deleteCustomerUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

}
