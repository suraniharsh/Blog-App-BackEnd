package com.surani.blog.services;

import com.surani.blog.payloads.Dtos.UserDto;

import java.util.List;

public interface UserServices {

//    Create User
    UserDto createUser(UserDto userDto);

//    Update User
    UserDto updateUser(UserDto userDto, Integer userId);

//    Get User by Id
    UserDto getUserById(Integer userId);

//    Delete User
    void deleteUser(Integer userId);

//    get all users
    List<UserDto> getAllUsers();

}
