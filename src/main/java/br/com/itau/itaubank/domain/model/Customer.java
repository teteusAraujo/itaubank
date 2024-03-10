package br.com.itau.itaubank.domain.model;

import br.com.itau.itaubank.adapter.persistence.entity.CustomerEntity;

public class Customer {
    private Long id;
    private String name;
    private  String cpf;
    private String email;

    public Customer(Long id ,String name, String cpf, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }
    public Customer(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Boolean IDoNotSave(){
        return this.id == null;
    }
}
