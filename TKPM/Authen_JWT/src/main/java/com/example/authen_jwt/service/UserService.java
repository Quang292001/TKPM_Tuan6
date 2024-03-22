package com.example.authen_jwt.service;

import com.example.authen_jwt.authen.UserPrincipal;
import com.example.authen_jwt.entity.User;

public interface UserService {
    User createUser(User user);
    UserPrincipal findByUsername(String username);
}
