package com.xa.batch342.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.xa.batch342.entities.OrderHeader;
import com.xa.batch342.entities.Variant;

import lombok.Data;

@Data
public class OrderDetailResponseDto {
    private OrderHeader orderHeader;
    private Variant variant;
    private BigDecimal price;
    private BigDecimal quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDeleted;
}
