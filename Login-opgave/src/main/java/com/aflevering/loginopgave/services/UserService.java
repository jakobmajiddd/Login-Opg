package com.aflevering.loginopgave.services;

import com.aflevering.loginopgave.models.User;
import com.aflevering.loginopgave.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final com.aflevering.loginopgave.repositories.userRepository userRepository;

    @Autowired
    public UserService(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean usernameTaken(User user) {
        Optional<User> userOptional = userRepository.findUserByName(user.getUsername());
        return userOptional.isPresent();

    }

    public boolean correctInformations(User user) {
        Optional<User> userOptional = userRepository.findByUserAndPassword(user.getUsername(), user.getPassword());
        return userOptional.isPresent();
    }

    public List<User> bringAllUsers() {
        return userRepository.findAll();
    }


}
