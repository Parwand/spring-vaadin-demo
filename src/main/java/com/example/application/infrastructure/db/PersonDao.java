package com.example.application.infrastructure.db;

import com.example.application.infrastructure.dto.PersonDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonDao extends CrudRepository<PersonDto, Long> {

    List<PersonDto> findAll();
}
