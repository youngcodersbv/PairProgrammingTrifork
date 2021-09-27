package com.example.springboot.repository;

import com.example.springboot.model.Commute;
import org.springframework.data.repository.CrudRepository;

public interface CommuteRepository extends CrudRepository<Commute, Long>  {

    Commute findById(long id);
}
