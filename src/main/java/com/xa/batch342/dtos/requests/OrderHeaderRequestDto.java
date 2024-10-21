package com.xa.batch342.dtos.requests;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderHeaderRequestDto {
    private String referee;
    private BigDecimal amount;
    private Boolean isDeleted;
}
