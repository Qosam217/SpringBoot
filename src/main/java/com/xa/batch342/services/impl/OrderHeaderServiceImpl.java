package com.xa.batch342.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.batch342.entities.OrderHeader;
import com.xa.batch342.repositories.OrderHeaderRepository;
import com.xa.batch342.services.OrderHeaderService;

@Service
public class OrderHeaderServiceImpl implements OrderHeaderService{
     @Autowired
    OrderHeaderRepository orderHeaderRepository;

    @Override
    public List<OrderHeader> getAllOrdersHeader() {
        return orderHeaderRepository.getAllOrdersHeader();
    }

    @Override
    public OrderHeader saveOrderHeader(OrderHeader orderHeader) {
        return orderHeaderRepository.save(orderHeader);
    }

    
    @Override
    public OrderHeader getOrderHeaderById(Long id){
        return orderHeaderRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOrderHeaderById(Long id){
        OrderHeader orderHeader = orderHeaderRepository.findById(id).orElse(null);
        orderHeaderRepository.deleteById(orderHeader.getId());
    }
}
