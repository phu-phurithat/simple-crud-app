package com.phu.crudapi.services;

import com.phu.crudapi.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> findAllUsers();
    User findUserById(int id);
    void deleteUserById(int id);
}
