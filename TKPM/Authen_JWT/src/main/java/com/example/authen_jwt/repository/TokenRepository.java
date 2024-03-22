package com.example.authen_jwt.repository;

import com.example.authen_jwt.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}
