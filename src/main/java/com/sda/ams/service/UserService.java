package com.sda.ams.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.ams.model.User;
import com.sda.ams.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> get(Integer id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Integer id) {
        Optional<User> optionalUser = get(id);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
        }
    }
}
