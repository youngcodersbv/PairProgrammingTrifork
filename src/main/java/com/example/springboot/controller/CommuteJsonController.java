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
    public Commute[] getAllCommuteInJson(@RequestParam(value = "filter",required = false) String someStringValue) {
        Iterable<Commute> commutes = commuteRepository.findAll();

        List<Commute> result = new ArrayList();
        StreamSupport.stream(commutes.spliterator(),false)
                // The fully written out lambda
                .filter((Commute commute) -> {
                    if(someStringValue == null) {
                        return true;
                    }
                    if(commute.getHome().toLowerCase(Locale.ROOT)
                            .contains(someStringValue.toLowerCase(Locale.ROOT))) {
                        return true;
                    } else if(commute.getWork().toLowerCase(Locale.ROOT)
                            .contains(someStringValue.toLowerCase(Locale.ROOT))) {
                        return true;
                    } else {
                        return false;
                    }
                })
                // The shorter lambda using the filter in Commute
                .filter((Commute commute) -> {
                    return Commute.filter(someStringValue, commute);
                })
                // The shortest lambda using filter in Commute
                .filter(commute -> Commute.filter(someStringValue, commute))
                // Using a function to return a function
                .filter(createFilter(someStringValue))
                // All "Predicate" functions accept 1 Commute parameter and return a boolean value
                .forEach(result::add);

        return result.toArray(new Commute[result.size()]);
    }

    @GetMapping("/{id}")
    public Commute getUserById(@PathVariable("id") long id) {
        Optional<Commute> optionsCommute = commuteRepository.findById(id);

        return optionsCommute.get();
    }

}
