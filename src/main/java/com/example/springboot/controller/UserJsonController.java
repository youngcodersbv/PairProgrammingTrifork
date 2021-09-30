package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping(path = "/json/users")
public class UserJsonController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public User[] getAllUserInJson() {
        Iterable<User> users = userRepository.findAll();

        // Loads all user into memory
        List<User> result = new ArrayList();
        users.forEach(result::add);

        return result.toArray(new User[result.size()]);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") long id) {
        Optional<User> optionsUser = userRepository.findById(id);

        return optionsUser.get();
    }

}
