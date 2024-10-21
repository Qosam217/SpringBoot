package com.xa.batch342.services;

import java.util.List;

import com.xa.batch342.entities.OrderHeader;

public interface OrderHeaderService {
    List<OrderHeader> getAllOrdersHeader();
    OrderHeader saveOrderHeader(OrderHeader orderHeader);
    OrderHeader getOrderHeaderById(Long id);
    void deleteOrderHeaderById(Long id);
}
