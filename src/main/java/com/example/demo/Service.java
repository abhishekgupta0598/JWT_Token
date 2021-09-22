package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<User> getByUserName(String username) {
        List<User> users = getUser();
        for(User u : users) {
            if(u.getUsername().equals(username)) {
                Integer id = u.getId();
                Optional<User> user = getUserById(id);
                return user;
            }
        }
        return null;
    }
}
