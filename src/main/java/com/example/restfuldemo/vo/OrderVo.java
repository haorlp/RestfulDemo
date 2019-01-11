package com.example.restfuldemo.vo;

import java.sql.Date;

/**
 * @program: webbase
 * @description:
 * @author: wlp
 * @create: 2019/1/9 16:08
 **/
public class OrderVo {
    private String orderName;
    private double price;



    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                ", orderName='" + orderName + '\'' +
                ", price=" + price +
                '}';
    }
}
