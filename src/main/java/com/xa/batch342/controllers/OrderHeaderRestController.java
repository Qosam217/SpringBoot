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

import com.xa.batch342.dtos.requests.OrderHeaderRequestDto;
import com.xa.batch342.dtos.responses.OrderHeaderResponseDto;
import com.xa.batch342.entities.OrderHeader;
import com.xa.batch342.services.OrderHeaderService;

@RestController
@RequestMapping("/api/order_header")
public class OrderHeaderRestController {

    @Autowired
    OrderHeaderService orderHeaderService;

    @GetMapping("")
    public ResponseEntity<?> getAllOrdersHeader() {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        try {
            List<OrderHeader> orderHeaders = orderHeaderService.getAllOrdersHeader();
            List<OrderHeaderResponseDto> orderHeaderResponseDtos = orderHeaders.stream().map(orderHeader -> modelMapper.map(orderHeader, OrderHeaderResponseDto.class)).collect(Collectors.toList());
            resultMap.put("status", 200);
            resultMap.put("message", "success");
            resultMap.put("data", orderHeaderResponseDtos);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", "failed");
            resultMap.put("error", e);
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> saveOrderHeader(@RequestBody OrderHeaderRequestDto orderHeaderRequestDto) {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        try {
            OrderHeader orderHeader = modelMapper.map(orderHeaderRequestDto, OrderHeader.class);
            orderHeaderService.saveOrderHeader(orderHeader);
            resultMap.put("status", 200);
            resultMap.put("message", "success");
            resultMap.put("data", orderHeader);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", "failed");
            resultMap.put("error", e);
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderHeaderById(@PathVariable("id") Long id, @RequestBody OrderHeaderRequestDto orderHeaderRequestDto) {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        try {
            OrderHeader orderHeader = orderHeaderService.getOrderHeaderById(id);
            modelMapper.map(orderHeaderRequestDto, orderHeader);
            orderHeaderService.saveOrderHeader(orderHeader);
            resultMap.put("status", 200);
            resultMap.put("message", "success");
            resultMap.put("data", orderHeader);
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", "failed");
            resultMap.put("error", e);
            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderHeaderById(@PathVariable ("id") Long id){
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        try {
            orderHeaderService.deleteOrderHeaderById(id);
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
