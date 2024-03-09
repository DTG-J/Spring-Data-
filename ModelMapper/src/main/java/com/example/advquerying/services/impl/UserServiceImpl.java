package com.example.advquerying.services.impl;

import com.example.advquerying.repositories.UserRepository;
import com.example.advquerying.services.dtos.UserRegisterDTO;
import com.example.advquerying.services.UserService;
import com.example.advquerying.util.ValidatorService;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ValidatorService validatorService;
    public UserServiceImpl(UserRepository userRepository, ValidatorService validatorService) {
        this.userRepository = userRepository;
        this.validatorService = validatorService;
    }

    @Override
    public String registerUser(UserRegisterDTO userRegisterDTO) {

        if (!this.validatorService.isValid(userRegisterDTO)){
            Set<ConstraintViolation<UserRegisterDTO>> set = this.validatorService.validate(userRegisterDTO);
            return set.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n"));
        }

        if  (!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword()))
            return "Passwords don't match.";

        return "User registration successful";
    }

}
