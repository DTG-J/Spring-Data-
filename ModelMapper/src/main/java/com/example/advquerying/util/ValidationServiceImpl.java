package com.example.advquerying.util;

import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class ValidationServiceImpl implements ValidatorService{

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private ValidationServiceImpl(Validator validator){

    }
    @Override
    public <E> boolean isValid(E entity) {
        return this.validator.validate(entity).isEmpty();
    }

    @Override
    public <E> Set<ConstraintViolation<E>> validate(E entity) {
        return this.validator.validate(entity);
    }
}
