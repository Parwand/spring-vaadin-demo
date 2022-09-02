package com.example.application.applicationservice.repository;

import com.example.application.infrastructure.dto.PersonDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository {

     List<PersonDto> findAll();
     void save(PersonDto personDto);

}
