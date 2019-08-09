package com.apicarrinhodecompra.orders.orderItem;

import com.apicarrinhodecompra.basicentity.BasicEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ORDER_ITEM", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class OrderItem extends BasicEntity {

    @NotNull(message = "Valor orderId é Obrigatório !")
    private Long orderId;
    @NotNull(message = "Valor productId é Obrigatório !")
    private Long productId;
    @NotNull(message = "Valor amount é Obrigatório !")
    private Integer amount;
    @NotNull(message = "Valor priceUnit é Obrigatório !")
    private Double priceUnit;
    @NotNull(message = "Valor total é Obrigatório !")
    private Double total;

    public OrderItem(Long id, Long orderId, Long productId, Integer amount, Double priceUnit, Double total) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
        this.priceUnit = priceUnit;
        this.total = total;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getProductId() {
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
