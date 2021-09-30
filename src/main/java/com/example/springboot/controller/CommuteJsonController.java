package com.example.springboot.controller;

import com.example.springboot.model.Commute;
import com.example.springboot.repository.CommuteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping(path = "/json/commute")
public class CommuteJsonController {

    @Autowired
    private CommuteRepository commuteRepository;

    @GetMapping
    public Commute[] getAllCommuteInJson() {
        Iterable<Commute> commutes = commuteRepository.findAll();

        List<Commute> result = new ArrayList();
        commutes.forEach(result::add);

        return result.toArray(new Commute[result.size()]);
    }

    @GetMapping("/{id}")
    public Commute getUserById(@PathVariable("id") long id) {
        Optional<Commute> optionsCommute = commuteRepository.findById(id);

        return optionsCommute.get();
    }

}
