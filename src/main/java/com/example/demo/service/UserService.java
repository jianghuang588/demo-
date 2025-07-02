package com.example.demo.service;




import com.example.demo.repository.UserRepository;
import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password) != null;
    }

    public boolean registerUser(String username, String password) {
        if (userRepository.existsByUsername(username)) {
            return false;
        }
        User user = new User(username, password);
        userRepository.save(user);
        return true;
    }
}