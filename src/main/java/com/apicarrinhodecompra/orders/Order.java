package com.apicarrinhodecompra.orders;

import com.apicarrinhodecompra.basicentity.BasicEntity;
import com.apicarrinhodecompra.customers.DTOCustomer;
import com.apicarrinhodecompra.orders.orderItem.DTOOrderItem;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_ORDER", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Order extends BasicEntity {

    @NotNull(message = "Valor customerId é Obrigatório !")
    private Long customerId;
    @NotNull(message = "Valor total é Obrigatório !")
    private Double total;
    @NotNull(message = "Valor status é Obrigatório !")
    private String status;
    @NotNull(message = "Valor createdAt é Obrigatório !")
    private Date createdAt;


    public Order() {
    }

    public Order(Long customerId, Double total, String status, Date createdAt) {
        this.customerId = customerId;
        this.total = total;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getCustomerId() { return customerId; }

    public Double getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreatedAt() { return createdAt; }

    public void setStatus(String status) {
        this.status = status;
    }

    public DTOOrder getDto(DTOCustomer customer, List<DTOOrderItem> items) {

        return new DTOOrder(id, total, status, createdAt, customer, items);
    }
}
