package com.sky.service;

import com.sky.dao.UserMapper;
import com.sky.model.User_4172;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User_4172> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public int insertUser(User_4172 user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int deleteUserById(String id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int updateUserById(User_4172 user) {
        return userMapper.updateUserById(user);
    }
}
