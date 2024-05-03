package com.hungpham.controller;

import com.hungpham.dtos.UserDto;
import com.hungpham.entity.UserEntity;
import com.hungpham.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/upsert-user")
    public UserEntity upsertUser(@RequestBody UserDto userDtos) {
        return userService.upsertUser(userDtos);
    }
}
