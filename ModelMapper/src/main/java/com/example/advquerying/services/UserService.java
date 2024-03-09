package com.example.advquerying.services;

import com.example.advquerying.services.dtos.UserRegisterDTO;

public interface UserService {
    String registerUser(UserRegisterDTO userRegisterDTO);
}
