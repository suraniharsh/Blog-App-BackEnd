package com.surani.blog.controllers;

import com.surani.blog.payloads.ApiResponse;
import com.surani.blog.payloads.Dtos.UserDto;
import com.surani.blog.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/")
public class UserControllers {

    private final UserServices userServices;

    @Autowired
    public UserControllers(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(this.userServices.createUser(userDto), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer userId) {
        return new ResponseEntity<>(this.userServices.updateUser(userDto, userId), HttpStatus.OK);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer userId) {
        return new ResponseEntity<>(this.userServices.getUserById(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId) {
        this.userServices.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User deleted successfully"), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(this.userServices.getAllUsers(), HttpStatus.OK);
    }

}
