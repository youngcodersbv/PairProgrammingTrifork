package com.example.springboot.controller;

import com.example.springboot.dto.AddCommuteCommand;
import com.example.springboot.model.Commute;
import com.example.springboot.model.User;
import com.example.springboot.repository.CommuteRepository;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/commutes")
public class CommuteController {

    @Autowired
    private CommuteRepository commuteRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String index(Model model) {
        Iterable iter = commuteRepository.findAll();
        model.addAttribute("xxx", iter);
        return "commutes";
    }

    @PostMapping()
    public String postIndex(@ModelAttribute AddCommuteCommand commuteCommand) {

        Optional<User> optionalUser = userRepository.findById(commuteCommand.getUserId());
        optionalUser.ifPresent((User user) -> {
            // Work with user...
            Commute commute = new Commute();
            commute.setHome(commuteCommand.getHome());
            commute.setWork(commuteCommand.getWork());
            commute.setUser(user);
            user.getCommutes().add(commute);
            userRepository.save(user);
        });
        return "redirect:/commutes";
    }





}
