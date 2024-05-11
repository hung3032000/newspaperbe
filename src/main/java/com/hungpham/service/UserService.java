package com.hungpham.service;

import com.hungpham.dtos.UserDto;
import com.hungpham.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUser();

    UserEntity upsertUser(UserDto userDtos);
    UserEntity newUser (UserDto userDtos);

    UserEntity softDeleteUser(String id);
}
