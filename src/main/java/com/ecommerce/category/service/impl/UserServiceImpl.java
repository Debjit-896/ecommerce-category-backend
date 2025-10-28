package com.ecommerce.category.service.impl;

import com.ecommerce.category.exception.UserException;
import com.ecommerce.category.model.User;
import com.ecommerce.category.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findUserById(Long userId) throws UserException {
        return null;
    }
}
