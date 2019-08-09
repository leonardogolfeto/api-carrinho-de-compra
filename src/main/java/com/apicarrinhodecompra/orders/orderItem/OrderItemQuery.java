package com.apicarrinhodecompra.orders.orderItem;

import com.apicarrinhodecompra.BasicEntity.BasicQuery;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderItemQuery extends BasicQuery {

    public List<DTOOrderItem> getItensByCustomerId(Long customerId) {
        String sql = " SELECT " +
                " ITEM.amount," +
                " ITEM.price_unit," +
                " ITEM.total," +
                " ITEM.product_id" +
                " FROM  ORDER_ITEM AS ITEM\n" +
                " INNER JOIN TB_ORDER ON TB_ORDER.ID = ITEM.ORDER_ID AND TB_ORDER.CUSTOMER_ID = " + customerId + "\n";

        try {

            List<DTOOrderItem> dtoOrderItems = new ArrayList<>();
            List<Object[]> resultados = em.createNativeQuery(sql).getResultList();

            for (Object[] resultado : resultados) {

                int index = -1;
                DTOOrderItem dto = new DTOOrderItem();
                dto.setAmount((Integer) resultado[++index]);
                dto.setPrice_unit((Double) resultado[++index]);
                dto.setTotal((Double) resultado[++index]);
                BigInteger productId = new BigInteger(resultado[++index].toString());
                dto.setId(productId.longValue());

                dtoOrderItems.add(dto);
            }
            return dtoOrderItems;
        } catch (NoResultException ex) {
            return null;
        }

    }
}
