package com.xa.batch342.dtos.responses;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CategoryResponseDto {
    private String name;
    private String slug;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active;

}
