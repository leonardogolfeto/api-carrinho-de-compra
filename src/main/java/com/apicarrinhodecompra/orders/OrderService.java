package com.apicarrinhodecompra.orders;

import com.apicarrinhodecompra.customers.Customer;
import com.apicarrinhodecompra.customers.CustomerService;
import com.apicarrinhodecompra.orders.orderItem.DTOOrderItem;
import com.apicarrinhodecompra.orders.orderItem.OrderItemService;
import com.apicarrinhodecompra.products.Product;
import com.apicarrinhodecompra.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    public List<DTOOrder> listarOrders() {

        List<DTOOrder> dtosOrders = new ArrayList<>();

        List<Order> orders = repository.findAll();

        for (Order order : orders) {
            dtosOrders.add(
                    order.getDto(
                            customerService.getById(order.getCustomerId()).getDto(),
                            orderItemService.getItensByCustomerId(order.getCustomerId())));
        }
        return dtosOrders;
    }

    public Order adicionarOrder(DTOOrder dtoOrder) {

        Customer customer = customerService.getById(dtoOrder.getBuyer().getId());
        System.out.println("Adicionando Customer: " + customer.getDto() + " na Order.");
        Order order = repository.save(dtoOrder.getEntity());

        for (DTOOrderItem item : dtoOrder.getItems()) {

            Product product = productService.getById(item.getProduct().getId());
            System.out.println("Adicionando Product: " + product.getDto() + " No item");
            orderItemService.salvar(
                    item.getEntity(order.getId()));
        }
        return order;
    }

    public Order atualizarStatus(DTOAlteracaoStatusOrder dto) {

        Order order = repository.getOne(dto.getOrder_id());
        System.out.println("Atualizando status na Order: " + order.getId());
        order.setStatus(dto.getStatus());

        return repository.save(order);
    }
}
