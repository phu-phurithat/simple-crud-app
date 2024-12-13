package com.phu.crudapi.services;

import com.phu.crudapi.entity.User;
import com.phu.crudapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceAction implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceAction(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User data = null;
        if (optionalUser.isPresent()) {
            data = optionalUser.get();
        } else {
            throw new RuntimeException("User not found " + id);
        }
        return data;
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
