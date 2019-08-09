package com.apicarrinhodecompra.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/v1/orders", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public List<DTOOrder> listarOrders() { return orderService.listarOrders();
    }

    @RequestMapping(value = "/v1/orders", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Order> adicionarOrder(@RequestBody @Valid DTOOrder dtoOrder) {
        return new ResponseEntity<>(orderService.adicionarOrder(dtoOrder), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/v1/orders/{order_id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Order> atualizarStatus(@PathVariable String order_id, @RequestBody DTOAlteracaoStatusOrder dto){
        return new ResponseEntity<>(orderService.atualizarStatus(dto), HttpStatus.OK);

    }
}
