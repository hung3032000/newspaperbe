package com.hungpham.service.impl;

import com.hungpham.common.exception.BadRequestException;
import com.hungpham.dtos.UserDto;
import com.hungpham.entity.UserEntity;
import com.hungpham.mappers.UserMapper;
import com.hungpham.repository.UserRepository;
import com.hungpham.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
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
        if (null == userDtos.getId()) {
            throw new BadRequestException("Not found user id to update");
        }
        logger.info("Update user id {}", userDtos.getId());
        UserEntity userEntity = userRepository.findById(userDtos.getId()).orElseThrow(() -> new EntityNotFoundException("User not found " + userDtos.getId()));
        userDtos.setCreatedDate(userEntity.getCreatedDate());
        userDtos.setUpdatedDate(new Date());
        UserEntity finalUserEntity = userMapper.toEntity(userDtos);
        return userRepository.save(finalUserEntity);
    }

    @Override
    public UserEntity newUser(UserDto userDtos) {
        UUID uuid = UUID.randomUUID();
        userDtos.setId(String.valueOf(uuid));
        userDtos.setCreatedDate(new Date());
        logger.info("Add new user {}", userDtos);
        UserEntity userEntity = userMapper.toEntity(userDtos);
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity softDeleteUser(String id) {
        logger.info("Delete user which id is {}", id);
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found " + id));
        userEntity.setStatus(false);
        userEntity.setUpdatedDate(new Date());
        return userRepository.save(userEntity);
    }
}
