package com.restaurant.workshopmongodb.service;

import com.restaurant.workshopmongodb.models.User;
import com.restaurant.workshopmongodb.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private userRepository userRepository;

    public List<User> findAll(){{
        return userRepository.findAll();}
    }
}
