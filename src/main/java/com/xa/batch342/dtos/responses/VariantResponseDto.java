package com.xa.batch342.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.xa.batch342.entities.Product;

import lombok.Data;

@Data
public class VariantResponseDto {
    private String name;
    private String slug;
    private String description;
    private Product product;
    private BigDecimal price;
    private BigDecimal stock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active;
}
