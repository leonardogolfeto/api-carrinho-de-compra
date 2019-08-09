package com.apicarrinhodecompra.basicentity;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class BasicQuery {

    @PersistenceContext
    protected EntityManager em;

}
