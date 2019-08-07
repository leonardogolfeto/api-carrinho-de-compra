package com.apicarrinhodecompra.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> listarProdutos() {
        return productRepository.findAll();
    }

    public Product adicionarProduto(Product product) {
        return productRepository.save(product);
    }
}