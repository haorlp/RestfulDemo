package com.example.restfuldemo.repository;

import com.example.restfuldemo.Entity.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @program: webbase
 * @description:
 * @author: wlp
 * @create: 2019/1/10 10:07
 **/
public interface OrderRepository extends JpaRepository<OrderForm,Integer>, JpaSpecificationExecutor<OrderForm> {

    @Query(nativeQuery = true, value = "SELECT * FROM order_form o WHERE o.order_id=?1")
    OrderForm getOrderForm(Integer orderId);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM order_form o WHERE o.order_id=?1")
    OrderForm deleteAllByOrderId(Integer orderId);

    @Modifying
    @Transactional
    @Query("UPDATE OrderForm o SET o.orderName = ?2 WHERE o.orderId=?1")
    int updateByOrderId(Integer orderId,String name);
}
