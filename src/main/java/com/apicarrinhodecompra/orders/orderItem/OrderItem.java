package com.apicarrinhodecompra.orders.orderItem;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ORDER_ITEM", uniqueConstraints={@UniqueConstraint(columnNames = {"id"})})
public class OrderItem{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Integer productId;

    @Min(0)
    private Integer amount;

    @Min(0)
    private Double priceUnit;

    @Min(0)
    private Double total;

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public Double getPriceUnit() {
        return priceUnit;
    }

    public Double getTotal() {
        return total;
    }
}
