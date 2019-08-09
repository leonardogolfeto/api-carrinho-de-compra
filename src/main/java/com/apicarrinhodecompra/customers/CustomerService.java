package com.apicarrinhodecompra.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer adicionarCustProductomer(Customer customer) {
       return repository.save(customer);
    }

    public List<Customer> listarCustomers() { return repository.findAll(); }

    public Customer getById(Long id){ return repository.getOne(id); }
}
