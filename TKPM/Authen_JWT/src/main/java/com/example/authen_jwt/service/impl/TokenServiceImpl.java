package com.example.authen_jwt.service.impl;

import com.example.authen_jwt.entity.Token;
import com.example.authen_jwt.repository.TokenRepository;
import com.example.authen_jwt.service.TokenService;
import com.example.authen_jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private JwtUtil jwtUtil;
    public Token createToken(Token token) {
        return tokenRepository.saveAndFlush(token);
    }

    @Override
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }
}
