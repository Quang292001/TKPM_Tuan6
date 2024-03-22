package com.example.authen_jwt.service;

import com.example.authen_jwt.entity.Token;

public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);

}
