package com.xa.batch342.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xa.batch342.entities.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Object>{
    @Query(value = "select od from OrderDetail od where isDeleted = false")
    List<OrderDetail> getAllOrdersDetail();

    @Query(value = "select od from OrderDetail od where isDeleted=false and orderHeaderId = :id")
    List<OrderDetail> getOrdersByHeaderId(@Param("id") Long id);
}
