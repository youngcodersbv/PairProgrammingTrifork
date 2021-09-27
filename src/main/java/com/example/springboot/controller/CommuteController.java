package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.repository.CommuteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/commutes")
public class CommuteController {

    @Autowired
    private CommuteRepository repository;

    @GetMapping
    public String index(Model model) {
        Iterable iter = repository.findAll();
        model.addAttribute("commutes", iter);
        return "commutes";
    }
    /*
    @PostMapping("/")
    public String postIndex(@ModelAttribute User user) {
        repository.save(user);
        return "redirect:/";
    }
    */





}
