package com.example.restfuldemo.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: webbase
 * @description:
 * @author: wlp
 * @create: 2019/1/9 17:09
 **/
@Entity
@Table(name = "order_form")
public class OrderForm {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;


    @Column(name = "order_name")
    private String orderName;

    @Column(name = "price")
    private double price;

    @Column(name = "create_time")
    private Date createTime;

    public Integer getOrderId() {
        return orderId;
    }

    public OrderForm setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getOrderName() {
        return orderName;
    }

    public OrderForm setOrderName(String orderName) {
        this.orderName = orderName;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public OrderForm setPrice(double price) {
        this.price = price;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public OrderForm setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                '}';
    }
}
