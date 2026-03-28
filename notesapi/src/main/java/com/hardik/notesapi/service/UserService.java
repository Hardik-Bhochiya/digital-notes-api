package com.hardik.notesapi.service;

import com.hardik.notesapi.entity.User;
import com.hardik.notesapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    // REGISTER USER
    public User saveUser(User user) {

        if (user.getPassword() == null) {
            throw new RuntimeException("Password cannot be null");
        }

        user.setPassword(encoder.encode(user.getPassword())); // 🔥 encrypt
        return repo.save(user);
    }

    // LOGIN
    public String login(String username, String password) {

        User user = repo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (encoder.matches(password, user.getPassword())) {
            return "Login Successful";
        } else {
            throw new RuntimeException("Invalid Password");
        }
    }
}