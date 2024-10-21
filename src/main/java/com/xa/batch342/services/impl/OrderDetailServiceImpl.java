package com.xa.batch342.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.batch342.entities.OrderDetail;
import com.xa.batch342.repositories.OrderDetailRepository;
import com.xa.batch342.services.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements  OrderDetailService{
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> getAllOrdersDetail() {
        return orderDetailRepository.getAllOrdersDetail();
    }

    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    
    @Override
    public OrderDetail getOrderDetailById(Long id){
        return orderDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOrderDetailById(Long id){
        OrderDetail orderDetail = orderDetailRepository.findById(id).orElse(null);
        orderDetailRepository.deleteById(orderDetail.getId());
    }

    @Override
    public List<OrderDetail> getOrdersByHeaderId(Long id){
        return orderDetailRepository.getOrdersByHeaderId(id);
    }
}
