package br.com.itau.itaubank.adapter.persistence.entity;

import br.com.itau.itaubank.domain.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "customer")
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<AccountEntity> accounts = new ArrayList<>();


    public static CustomerEntity fromDomain(Customer customer) {
        return  new CustomerEntity(
                customer.getId(),
                customer.getName(),
                customer.getCpf(),
                customer.getEmail(),
                List.of()
        );
    }

    public Customer toDomain() {
        return new Customer(
                this.getId(),
                this.getName(),
                this.getCpf(),
                this.getEmail()
        );
    }

}
