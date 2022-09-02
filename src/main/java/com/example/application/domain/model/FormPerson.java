package com.example.application.domain.model;

import com.example.application.applicationservice.service.PersonService;
import com.example.application.infrastructure.dto.PersonDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;


public class FormPerson extends FormLayout {
    PersonService personService;
    TextField firstname = new TextField("firstname");
    TextField lastname  = new TextField("lastname");
    TextField email     = new TextField("email");
    TextField role     = new TextField("role");
    Binder<PersonDto> binder = new Binder<>(PersonDto.class);
    PersonDto personDto = new PersonDto();

    public FormPerson(PersonService personService) {
        this.personService = personService;
        binder.bindInstanceFields(this);



        Button saveButton = new Button("save");
        saveButton.addClickListener(buttonClickEvent -> {
            personDto.setFirstname(firstname.getValue());
            personDto.setLastname(lastname.getValue());
            personDto.setEmail(email.getValue());
            personDto.setRole(role.getValue());
            personService.save(personDto);
        });
        add(firstname, lastname, email, role, saveButton);
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
        binder.readBean(personDto);
    }
}
