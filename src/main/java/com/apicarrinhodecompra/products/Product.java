package com.apicarrinhodecompra.products;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "PRODUCT", uniqueConstraints = {@UniqueConstraint(columnNames = {"sku"}), @UniqueConstraint(columnNames = {"name"}), @UniqueConstraint(columnNames = {"id"})})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Valor sku é Obrigatório !")
    private Long sku;

    @NotNull(message = "Valor nome é Obrigatório !")
    private String name;

    @Min(0)
    @NotNull(message = "Valor preco é Obrigatório !")
    private Double price;

    @NotNull(message = "Valor created_at é Obrigatório !")
    private Date created_at;

    @NotNull(message = "Valor updated_at é Obrigatório !")
    private Date updated_at;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
