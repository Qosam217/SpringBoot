package com.xa.batch342.dtos.requests;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderDetailRequestDto {
    private Long orderHeaderId;
    private Long variantId;
    private BigDecimal price;
    private BigDecimal quantity;
    private Boolean isDeleted;
}
