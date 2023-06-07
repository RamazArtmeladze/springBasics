package com.example.demo.configuration;



import com.example.demo.userController.UserController;
import com.example.demo.userRepository.UserRepository;
import com.example.demo.userService.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(AppConfiguration.class, args);
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public UserController userController(UserService userService) {
        return new UserController(userService);
    }

}

