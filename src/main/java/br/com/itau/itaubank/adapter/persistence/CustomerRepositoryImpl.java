package br.com.itau.itaubank.adapter.persistence;

import br.com.itau.itaubank.adapter.persistence.entity.CustomerEntity;
import br.com.itau.itaubank.adapter.persistence.repository.CustomerJpaRepository;
import br.com.itau.itaubank.application.ports.out.CustomerRepository;
import br.com.itau.itaubank.domain.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    CustomerJpaRepository repository;

    @Override
    @Transactional
    public Customer create(Customer customer){
        customerValidator(customer);
       CustomerEntity customerEntity = repository.save(CustomerEntity.fromDomain(customer));
       return customerEntity.toDomain();
    }

    @Override
    public Customer update( Long id, Customer customer) {
        if (repository.existsById(id)) {
            customer.setId(id);
            return repository.save(CustomerEntity.fromDomain(customer)).toDomain();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Customer> findById(Long id) {
      return repository.findById(id).map(CustomerEntity::toDomain);
    }

    @Override
    public List<Customer> findAll() {
        List<CustomerEntity> findAll = repository.findAll();
        return findAll.stream()
                .map(CustomerEntity::toDomain)
                .collect(Collectors.toList());

    }

    public void customerValidator(Customer customer) {
        if (customer.IDoNotSave() && repository.existsByEmailOrCpf(customer.getEmail(), customer.getCpf())) {
            throw new RuntimeException("Já existe um cliente cadastrado com esse email ou Cpf");
        }
    }
}
