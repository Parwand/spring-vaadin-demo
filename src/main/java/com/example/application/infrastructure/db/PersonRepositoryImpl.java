package com.example.application.infrastructure.db;

import com.example.application.applicationservice.repository.PersonRepository;
import com.example.application.infrastructure.dto.PersonDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    PersonDao personDao;

    public PersonRepositoryImpl(PersonDao personDao) {
        this.personDao = personDao;
    }


    @Override
    public List<PersonDto> findAll() {
        return personDao.findAll();
    }

    @Override
    public void save(PersonDto personDto) {
        personDao.save(personDto);
    }
}
