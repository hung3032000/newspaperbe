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
    @PostMapping("/new-user")
    public UserEntity newUser(@RequestBody UserDto userDtos) {
        return userService.newUser(userDtos);
    }

    @PutMapping("/update-user")
    public UserEntity updatetUser(@RequestBody UserDto userDtos) {
        return userService.upsertUser(userDtos);
    }

    @DeleteMapping
    public UserEntity softDeletedUser(@RequestBody String id) {
        return userService.softDeleteUser(id);
    }

}
