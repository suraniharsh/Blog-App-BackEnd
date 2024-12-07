package com.surani.blog.payloads.Dtos;

import lombok.Data;

@Data
public class UserDto {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private String about;

}