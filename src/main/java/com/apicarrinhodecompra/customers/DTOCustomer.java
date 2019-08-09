package com.apicarrinhodecompra.customers;

public class DTOCustomer {

    private Long id;
    private String name;
    private String cpf;
    private String email;

    public DTOCustomer(Long id, String name, String cpf, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() { return cpf; }

    public String getEmail() {
        return email;
    }
}
