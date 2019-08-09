package com.apicarrinhodecompra.products;

import javax.validation.constraints.NotNull;

public class DTOProduct {


    @NotNull(message = "Id não pode ser vazio !")
    private Long id;
    @NotNull(message = "Sku não pode ser vazio !")
    private Long sku;
    @NotNull(message = "Title não pode ser vazio !")
    private String title;

    public Long getId() { return id; }
    public Long getSku() { return sku; }
    public String getTitle() { return title; }

    public DTOProduct(Long id, Long sku, String title) {
        this.id = id;
        this.sku = sku;
        this.title = title;
    }
}
