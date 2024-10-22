package com.xa.batch342.dtos.requests;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class VariantRequestDto {
    private String name;
    private String slug;
    private String description;
    private Long productId;
    private BigDecimal price;
    private BigDecimal stock;
    private Boolean active;
}
