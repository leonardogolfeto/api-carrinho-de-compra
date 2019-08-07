package com.apicarrinhodecompra.customers;


import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "CUSTOMER",  uniqueConstraints={@UniqueConstraint(columnNames = {"cpf"}), @UniqueConstraint(columnNames = {"email"}), @UniqueConstraint(columnNames = {"id"})})
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Name é Obrigatório !")
    private String name;

    @NotNull(message = "Cpf é Obrigatório !")
    @CPF(message = "Cpf Inválido !")
    private String cpf;

    @NotNull(message = "E-mail é Obrigatório !")
    @Email(message = "E-mail Inválido !")
    private String email;

    @NotNull(message = "Created_at é Obrigatório !")
    private Date created_at;

    @NotNull(message = "Updated_at é Obrigatório !")
    private Date updated_at;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }
}
