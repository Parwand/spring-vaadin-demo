package com.example.application.applicationservice.repository;

import com.example.application.infrastructure.dto.PersonDto;

import java.util.List;

public interface PersonRepository {

     List<PersonDto> findAll();
     void save(PersonDto personDto);

}
