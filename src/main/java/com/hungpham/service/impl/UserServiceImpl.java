package com.hungpham.service.impl;

import com.hungpham.dtos.UserDto;
import com.hungpham.entity.UserEntity;
import com.hungpham.mappers.UserMapper;
import com.hungpham.repository.UserRepository;
import com.hungpham.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserDto> getAllUser() {
        return null;
    }

    @Override
    public UserEntity upsertUser(UserDto userDtos) {
        System.out.println(userDtos.getId());
        UserEntity userEntity = userMapper.toEntity(userDtos);
        System.out.println(userEntity.getId());
        return null;
//        return userRepository.save(userEntity);
    }
}
