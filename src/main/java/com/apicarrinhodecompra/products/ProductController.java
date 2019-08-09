package com.apicarrinhodecompra.products;

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
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/v1/products", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public List<Product> listaProdutos() {

        return productService.listarProdutos();
    }

    @RequestMapping(value = "/v1/products", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Product> adicionarProduto(@RequestBody @Valid Product product) {

        return new ResponseEntity<>(productService.adicionarProduto(product), HttpStatus.CREATED);
    }
}
