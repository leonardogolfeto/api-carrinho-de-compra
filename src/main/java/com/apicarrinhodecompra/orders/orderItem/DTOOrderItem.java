package com.apicarrinhodecompra.orders.orderItem;

import com.apicarrinhodecompra.products.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class DTOOrderItem {

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
    private Product product;

    public Integer getAmount() {
        return amount;
    }

    public Double getPrice_unit() {
        return price_unit;
    }

    public Double getTotal() {
        return total;
    }

    public Product getProduct() {
        return product;
    }
}
