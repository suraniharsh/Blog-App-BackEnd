package com.surani.blog.payloads.Dtos;

import lombok.Data;

import java.util.Date;

@Data
public class PostDto {

    private Integer id;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;

}
