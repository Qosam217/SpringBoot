package com.xa.batch342.controllers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xa.batch342.entities.OrderDetail;
import com.xa.batch342.entities.OrderHeader;
import com.xa.batch342.entities.Variant;
import com.xa.batch342.services.OrderDetailService;
import com.xa.batch342.services.OrderHeaderService;
import com.xa.batch342.services.VariantService;


@Controller
@RequestMapping("/transaction")
public class TransactionController {
        
    @Autowired
    OrderDetailService orderDetailService;
    
    @Autowired
    OrderHeaderService orderHeaderService;

    @Autowired
    VariantService variantService;

    @GetMapping("")
    public ModelAndView newOrder() {
        ModelAndView view = new ModelAndView("transaction/index");
        OrderHeader orderHeader = new OrderHeader(null, false);
        orderHeaderService.saveOrderHeader(orderHeader);
        Long id = orderHeader.getId();
        view.addObject("title", "Order");
        view.addObject("orderHeader", orderHeaderService.getOrderHeaderById(id));
        return view;
    }

    @GetMapping("/order/{id}")
    public ModelAndView getOrder(@PathVariable("id") Long id) {
        OrderHeader orderHeader = orderHeaderService.getOrderHeaderById(id);
        List<OrderDetail> orderDetails = orderDetailService.getOrdersByHeaderId(id);
        ModelAndView view = new ModelAndView("transaction/index");
        view.addObject("orderDetails",orderDetails);
        view.addObject("orderHeader", orderHeader);
        view.addObject("title", orderHeader.getId());
        return view;
    }
    

    @GetMapping("/create/{id}")
    public ModelAndView form(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView("transaction/create");
        List<Variant> variants = variantService.getAllVariants();
        OrderDetail orderDetail = new OrderDetail();
        OrderHeader orderHeader = orderHeaderService.getOrderHeaderById(id);
        view.addObject("variants", variants);
        view.addObject("orderHeader", orderHeader);
        view.addObject("orderDetail", orderDetail);
        return view;
    }
    
    @PostMapping("/save/{headerId}")
    public ModelAndView save(@ModelAttribute OrderDetail orderDetail, @PathVariable("id") Long id, @RequestParam String selectedVariants, BindingResult result) {
        List<Variant> variants = variantService.getAllVariants();
        List<Long> variantIds = Arrays.stream(selectedVariants.split(",")).map(Long::parseLong).collect(Collectors.toList());
        for(Long varId: variantIds){
            for(Variant variant: variants){
                if (varId == variant.getId()) {
                    OrderDetail newOrderDetail = new OrderDetail(new BigDecimal(1), id, variant.getId(), variant.getPrice(), false);
                    if (!result.hasErrors()) {
                        orderDetailService.saveOrderDetail(newOrderDetail);
                    }
                }
            }
        }
        return new ModelAndView("redirect:/variant/order/{id}");
    }
    
    @GetMapping("/deleteForm/{headerId}/{detailId}")
    public ModelAndView deleteForm(@PathVariable("headerId") Long headerId, @PathVariable("detailId") Long detailId) {
        ModelAndView view = new ModelAndView("transaction/delete");
        OrderDetail orderDetail = orderDetailService.getOrderDetailById(detailId);
        Variant variant = variantService.getVariantById(orderDetail.getVariantId());
        OrderHeader orderHeader = orderHeaderService.getOrderHeaderById(headerId);
        view.addObject("orderDetail", orderDetail);
        view.addObject("variant", variant);
        view.addObject("orderHeader", orderHeader);
        return view;
    }
    
    @GetMapping("/delete/{headerId}/{detailId}")
    public ModelAndView deleteOrderDetail(@PathVariable("headerId") Long headerId, @PathVariable("detailId") Long detailId) {
        orderDetailService.deleteOrderDetailById(detailId);;
        return new ModelAndView("redirect:/variant/order/{headerId}");
    }
}
