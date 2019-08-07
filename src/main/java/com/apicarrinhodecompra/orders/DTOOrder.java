package com.apicarrinhodecompra.orders;

import com.apicarrinhodecompra.customers.Customer;
import com.apicarrinhodecompra.orders.orderItem.DTOOrderItem;
import com.apicarrinhodecompra.orders.orderItem.OrderItem;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class DTOOrder {

    @NotNull()
    private Long id;

    @NotNull()
    private Long customerId;

    @Min(0)
    @NotNull()
    private Double total;

    @NotNull()
    private String status;

    @NotNull()
    private Date createdAt;

    @NotNull()
    private Customer buyer;

    @NotNull()
    private List<DTOOrderItem> items;

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Double getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Customer getBuyer() {
        return buyer;
    }

    public List<DTOOrderItem> getItems() {
        return items;
    }
}
