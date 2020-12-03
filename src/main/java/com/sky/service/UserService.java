package com.sky.service;


import com.sky.model.User_4172;

import java.util.List;

public interface UserService {
    List<User_4172> getAllUsers();
    int insertUser(User_4172 user);
    int deleteUserById(String id);
    int updateUserById(User_4172 user);
}
