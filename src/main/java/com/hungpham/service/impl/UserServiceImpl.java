package com.hungpham.service.impl;

import com.hungpham.common.exception.BadRequestException;
import com.hungpham.common.exception.EntityNotFoundException;
import com.hungpham.dtos.UserDto;
import com.hungpham.entity.UserEntity;
import com.hungpham.mappers.UserMapper;
import com.hungpham.repository.UserRepository;
import com.hungpham.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserEntity ue: userEntityList) {
            userDtoList.add(userMapper.toDto(ue));
        }
        return userDtoList;
    }

    @Override
    public UserDto getUserById(String id) {
        if (null == id) {
            throw new BadRequestException("Not found id for this user");
        }
        logger.info("Get user id {}", id);
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new BadRequestException("Not found user with id: " + id));
        return  userMapper.toDto(userEntity);
    }

    @Override
    public UserEntity updateUser(UserDto userDtos) {
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
        checkDuplicateUser(userDtos);
        logger.info("Add new user {}", userDtos);
        UserEntity userEntity = userMapper.toEntity(userDtos);
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity softDeleteUser(String id) {
        logger.info("Delete user which id is {}", id);
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found "));
        userEntity.setStatus(false);
        userEntity.setUpdatedDate(new Date());
        return userRepository.save(userEntity);
    }

    private void checkDuplicateUser(UserDto userDtos){
        int existFlag = userRepository.countByUserName(userDtos.getUserName());
        logger.info("User name check: {}. Flag is {}", userDtos.getUserName(), existFlag);
        if (existFlag != 0){
            throw new BadRequestException("This user is already exist");
        }
    }
}
