package com.example.restfuldemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.restfuldemo.entity.OrderForm;
import com.example.restfuldemo.common.BaseResult;
import com.example.restfuldemo.common.SuccessResp;
import com.example.restfuldemo.repository.OrderRepository;
import com.example.restfuldemo.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @program: webbase
 * @description:
 * @author: wlp
 * @create: 2019/1/9 14:54
 **/

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    //新增操作使用POST
    @RequestMapping(value = "",method = RequestMethod.POST)
    public BaseResult createOrder(@RequestBody OrderVo orderVo){
        BaseResult baseResult = null;
        OrderForm order = new OrderForm();
        order.setOrderName(orderVo.getOrderName())
                .setPrice(orderVo.getPrice())
                .setCreateTime(new Date());
        orderRepository.saveAndFlush(order);
        JSONObject jsonObject = new JSONObject();
        JSONObject object = new JSONObject();
        object.put("rel","cancel");
        object.put("url","/orders/"+order.getOrderId());
        jsonObject.put("orders",order);
        jsonObject.put("link",object);
        return new SuccessResp(jsonObject);
    }

    //查询操作使用GET
    @RequestMapping(value = "/{orderId}",method = RequestMethod.GET)
    public BaseResult getOrder(@PathVariable(value = "orderId") Integer orderId){
        OrderForm orderForm = orderRepository.getOrderForm(orderId);
        return new SuccessResp(orderForm);
    }

    //删除使用DELETE
    @RequestMapping(value = "/{orderId}",method = RequestMethod.DELETE)
    public BaseResult deleteOrder(@PathVariable(value = "orderId") Integer orderId){
        orderRepository.deleteById(orderId);
        return new SuccessResp();
    }

    //更新使用PATCH或者PUT
    @RequestMapping(value = "/{orderId}",method = RequestMethod.PATCH)
    public BaseResult putOrder(@PathVariable(value = "orderId") Integer orderId,String orderName){
        orderRepository.updateByOrderId(orderId,orderName);
        return new SuccessResp(orderRepository.findById(orderId));
    }
}
