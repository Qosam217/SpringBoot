package com.xa.batch342.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderHeaderResponseDto {
    private String referee;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active;
}
