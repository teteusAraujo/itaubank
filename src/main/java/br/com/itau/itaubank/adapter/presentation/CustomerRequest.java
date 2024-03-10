package br.com.itau.itaubank.adapter.presentation;

import br.com.itau.itaubank.domain.model.Customer;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    @NotBlank(message = "{campo.name.obrigatorio}")
    private String name;

    @NotBlank(message = "{campo.cpf.obrigatorio}")
    @Schema(description = "CPF do cliente (apenas números)", example = "06104642307")
    private String cpf;

    @NotBlank(message = "{campo.email.obrigatorio}")
    @Schema(description = "Email do cliente respeitando a formatação", example = "mock@email.com")
    private String email;

    public Customer toUserDomain() {
        return new Customer(
                name,
                cpf,
                email);
    }
}
