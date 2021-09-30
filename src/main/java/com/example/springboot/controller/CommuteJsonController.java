package com.example.springboot.controller;

import com.example.springboot.model.Commute;
import com.example.springboot.repository.CommuteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static com.example.springboot.model.Commute.createFilter;

@RestController()
@RequestMapping(path = "/json/commute")
public class CommuteJsonController {

    @Autowired
    private CommuteRepository commuteRepository;

    @GetMapping
    public Commute[] getAllCommuteInJson(@RequestParam(value = "filter",required = false) String filter) {
        Iterable<Commute> commutes = commuteRepository.findAll();

        List<Commute> result = new ArrayList();
        StreamSupport.stream(commutes.spliterator(),false)
                .filter(createFilter(filter))
                .forEach(result::add);

        return result.toArray(new Commute[result.size()]);
    }

    @GetMapping("/{id}")
    public Commute getUserById(@PathVariable("id") long id) {
        Optional<Commute> optionsCommute = commuteRepository.findById(id);

        return optionsCommute.get();
    }

}
