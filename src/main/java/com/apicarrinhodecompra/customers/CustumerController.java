package com.apicarrinhodecompra.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustumerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/v1/customers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Customer> adicionaProduto(@RequestBody @Valid Customer customer) {

        return new ResponseEntity<>(customerService.adicionarCustProductomer(customer), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/v1/customers", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public List<Customer> listaProdutos() {

        return customerService.listarCustomers();
    }
}
