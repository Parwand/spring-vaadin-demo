package com.example.application.applicationservice.service;

import com.example.application.applicationservice.repository.PersonRepository;
import com.example.application.infrastructure.dto.PersonDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDto> findAll() {
        return personRepository.findAll();
    }

    public void save(PersonDto personDto) {
        personRepository.save(personDto);
    }
}
