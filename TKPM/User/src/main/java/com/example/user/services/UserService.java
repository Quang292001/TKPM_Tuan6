package com.example.user.services;

import com.example.user.models.User;
import com.example.user.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getListUser(){
        return  userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findById(id).get();
    }
}
