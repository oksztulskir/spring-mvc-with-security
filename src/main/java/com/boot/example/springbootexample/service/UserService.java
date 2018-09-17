package com.boot.example.springbootexample.service;

import com.boot.example.springbootexample.model.Role;
import com.boot.example.springbootexample.model.User;
import com.boot.example.springbootexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public User findByLoginAndLastName(String login, String lastName) {
        return userRepository.findByLoginAndLastName(login, lastName);
    }

    public List<User> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void saveWithRoles() {
        User user = new User();
        user.setLogin("oksztul");
        user.setFirstName("Rafał");
        user.setLastName("Oksztulski");
        user.setEmailAddress("oksztul@gmail.com");
        user.setPassword("SDA_2018");
        Role roleAdmin = new Role();
        roleAdmin.setName(Role.RoleEnum.ADMIN);
        Role roleSuperuser = new Role();
        roleSuperuser.setName(Role.RoleEnum.SUPERUSER);
        Set<Role> roles = new HashSet<>(Arrays.asList(roleAdmin, roleSuperuser));
        user.setRoles(roles);
        userRepository.save(user);
    }
}
