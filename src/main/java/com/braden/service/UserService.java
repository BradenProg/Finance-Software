package com.braden.service;

import com.braden.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    public UserService(UserRepository userRepository) {

    }
}
