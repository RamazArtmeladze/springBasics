package com.example.demo.userService;

import com.example.demo.user.User;
import com.example.demo.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void fillDummyUsers() {
        User user1 = new User("1", "Ramaz Artmeladze");
        User user2 = new User("2", "Someone");

        createUser(user1);
        createUser(user2);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
