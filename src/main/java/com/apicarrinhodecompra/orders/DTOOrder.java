package com.apicarrinhodecompra.orders;

import com.apicarrinhodecompra.customers.DTOCustomer;
import com.apicarrinhodecompra.orders.orderItem.DTOOrderItem;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class DTOOrder {

    @NotNull()
    private Long id;
    @Min(0)
    @NotNull()
    private Double total;
    @NotNull()
    private String status;
    @NotNull()
    private Date created_at;
    @NotNull()
    private DTOCustomer buyer;
    @NotNull()
    private List<DTOOrderItem> items;

    public DTOOrder(@NotNull() Long id, @Min(0) @NotNull() Double total, @NotNull() String status, @NotNull() Date created_at, @NotNull() DTOCustomer buyer, @NotNull() List<DTOOrderItem> items) {
        this.id = id;
        this.total = total;
        this.status = status;
        this.created_at = created_at;
        this.buyer = buyer;
        this.items = items;
    }

    public Long getId() { return id; }
    public Double getTotal() { return total; }
    public String getStatus() { return status; }
    public Date getCreated_at() { return created_at; }
    public DTOCustomer getBuyer() { return buyer; }
    public List<DTOOrderItem> getItems() { return items; }

    @JsonIgnore
    public Order getEntity() {
        return new Order(
                this.buyer.getId(),
                this.total,
                this.status,
                this.created_at);
    }
}
