package com.apicarrinhodecompra.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> listarProdutos() {
        return repository.findAll();
    }

    public Product adicionarProduto(Product product) {
        return repository.save(product);
    }

    public DTOProduct getProductByOrderId(Long orderId) {
        return repository.getOne(orderId).getDto();
    }

    public Product getById(Long id) { return repository.getOne(id); }
}