package com.boot.example.springbootexample;

import com.boot.example.springbootexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.boot.example.springbootexample"})
//@EnableScheduling
@EnableJpaRepositories(basePackages = "com.boot.example.springbootexample.repository")
public class SpringBootExampleApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        userService.saveWithRoles();
    }
}
