package com.xa.batch342.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xa.batch342.dtos.requests.OrderDetailRequestDto;
import com.xa.batch342.dtos.responses.OrderDetailResponseDto;
import com.xa.batch342.entities.OrderDetail;
import com.xa.batch342.services.OrderDetailService;

@RestController
@RequestMapping("/api/order_detail")
public class OrderDetailRestController {
     @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("")
    public ResponseEntity<?> getAllOrdersDetail() {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        try {
            List<OrderDetail> orderDetails = orderDetailService.getAllOrdersDetail();
            List<OrderDetailResponseDto> orderDetailResponseDtos = orderDetails.stream().map(orderDetail -> modelMapper.map(orderDetail, OrderDetailResponseDto.class)).collect(Collectors.toList());
            resultMap.put("status", 200);
            resultMap.put("message", "success");
            resultMap.put("data", orderDetailResponseDtos);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", "failed");
            resultMap.put("error", e);
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> saveOrderDetail(@RequestBody OrderDetailRequestDto orderDetailRequestDto) {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        try {
            OrderDetail orderDetail = modelMapper.map(orderDetailRequestDto, OrderDetail.class);
            orderDetailService.saveOrderDetail(orderDetail);
            resultMap.put("status", 200);
            resultMap.put("message", "success");
            resultMap.put("data", orderDetail);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", "failed");
            resultMap.put("error", e);
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetailById(@PathVariable("id") Long id, @RequestBody OrderDetailRequestDto orderDetailRequestDto) {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        try {
            OrderDetail orderDetail = orderDetailService.getOrderDetailById(id);
            modelMapper.map(orderDetailRequestDto, orderDetail);
            orderDetailService.saveOrderDetail(orderDetail);
            resultMap.put("status", 200);
            resultMap.put("message", "success");
            resultMap.put("data", orderDetail);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", "failed");
            resultMap.put("error", e);
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetailById(@PathVariable ("id") Long id){
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        try {
            orderDetailService.deleteOrderDetailById(id);
            resultMap.put("status", 200);
            resultMap.put("message", "success");
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", "failed");
            resultMap.put("error", e);
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
