package com.example.authen_jwt.repository;

import com.example.authen_jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {

    User findByUsername(String username);
}