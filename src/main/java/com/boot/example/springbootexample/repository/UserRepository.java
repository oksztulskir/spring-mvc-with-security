package com.boot.example.springbootexample.repository;

import com.boot.example.springbootexample.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findByLoginAndLastName(String login, String lastName);
}
