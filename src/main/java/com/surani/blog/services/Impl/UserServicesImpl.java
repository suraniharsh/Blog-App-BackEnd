package com.surani.blog.services.Impl;

import com.surani.blog.exceptions.ResourceNotFoundException;
import com.surani.blog.models.User;
import com.surani.blog.payloads.Dtos.UserDto;
import com.surani.blog.repositorys.UserRepo;
import com.surani.blog.services.UserServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServicesImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        return this.modelMapper.map(this.userRepo.save(user), UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return this.modelMapper.map(this.userRepo.save(user), UserDto.class);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        return this.modelMapper.map(this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId)), UserDto.class);
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        this.userRepo.delete(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        return users.stream().map(user -> this.modelMapper.map(user, UserDto.class)).toList();
    }
}
