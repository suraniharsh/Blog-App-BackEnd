package com.surani.blog.payloads.Dtos;

import lombok.Data;

@Data
public class CategoryDto {
    private Integer categoryId;
    private String title;
    private String description;
}
