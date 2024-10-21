package com.xa.batch342.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xa.batch342.entities.OrderHeader;

@Repository
public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long>{
     @Query(value = "select oh from OrderHeader oh where isDeleted = false")
    List<OrderHeader> getAllOrdersHeader();
}
