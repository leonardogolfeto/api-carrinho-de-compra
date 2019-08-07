package com.apicarrinhodecompra.orders;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_ORDER", uniqueConstraints={@UniqueConstraint(columnNames = {"id"})})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer customerId;

    private Double total;

    private String status;

    private Date createdAt;

    public Long getId() {
        return id;
    }

    public Integer getCustomerId() {
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
}
