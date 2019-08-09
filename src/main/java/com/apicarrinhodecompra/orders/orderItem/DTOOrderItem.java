package com.apicarrinhodecompra.orders.orderItem;

import com.apicarrinhodecompra.products.DTOProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class DTOOrderItem {

    @Min(0)
    @NotNull()
    private Long id;

    @Min(0)
    @NotNull()
    private Integer amount;

    @Min(0)
    @NotNull(message = "Price_unit não pode ser null!")
    private Double price_unit;

    @Min(0)
    @NotNull(message = "Total não pode ser null!")
    private Double total;

    @NotNull(message = "Product não pode ser null!")
    private DTOProduct product;

    @JsonIgnore
    private Long productId;

    public Integer getAmount() {
        return amount;
    }

    public Double getPrice_unit() {
        return price_unit;
    }

    public Double getTotal() {
        return total;
    }

    public DTOProduct getProduct() {
        return product;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setPrice_unit(Double price_unit) {
        this.price_unit = price_unit;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setProduct(DTOProduct product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public OrderItem getEntity(Long orderId) {

        return new OrderItem(id ,orderId, product.getId(), amount, price_unit, total);
    }
}
