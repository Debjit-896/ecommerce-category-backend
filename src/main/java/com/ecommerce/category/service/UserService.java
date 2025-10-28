package com.ecommerce.category.service;

import com.ecommerce.category.exception.UserException;
import com.ecommerce.category.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User findUserById(Long userId) throws UserException;

}
