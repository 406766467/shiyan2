package com.sky.dao;

import com.sky.model.User_4172;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    List<User_4172> getAllUsers();
    int insertUser(User_4172 user);
    int deleteUserById(String id);
    int updateUserById(User_4172 user);
}
