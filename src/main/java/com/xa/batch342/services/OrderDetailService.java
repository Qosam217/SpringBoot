package com.xa.batch342.services;

import java.util.List;

import com.xa.batch342.entities.OrderDetail;

public interface  OrderDetailService {
    List<OrderDetail> getAllOrdersDetail();
    List<OrderDetail> getOrdersByHeaderId(Long id);
    OrderDetail saveOrderDetail(OrderDetail orderDetail);
    OrderDetail getOrderDetailById(Long id);
    void deleteOrderDetailById(Long id);
}
