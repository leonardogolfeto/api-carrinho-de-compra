package com.apicarrinhodecompra.orders.orderItem;


import com.apicarrinhodecompra.orders.DTOOrder;
import com.apicarrinhodecompra.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    @Autowired
    private OrderItemQuery query;

    @Autowired
    private ProductService productService;

    public void salvar(OrderItem orderItem) {

        repository.save(orderItem);
    }

    public List<DTOOrderItem> getItensByCustomerId(Long customerId) {

        List<DTOOrderItem> itens = query.getItensByCustomerId(customerId);

        for (DTOOrderItem dto : itens){
            dto.setProduct(productService.getProductByOrderId(dto.getId()));
        }

        return itens;
    }
}
