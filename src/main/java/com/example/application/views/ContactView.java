package com.example.application.views;

import com.example.application.applicationservice.service.PersonService;
import com.example.application.domain.model.FormPerson;
import com.example.application.infrastructure.dto.PersonDto;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "/contact", layout = MainLayout.class)
@PageTitle("Contact")
public class ContactView extends VerticalLayout {
    PersonService personService;

    public ContactView(PersonService personService) {
        this.personService = personService;

        var grid = new Grid<>(PersonDto.class);
        grid.setItems(personService.findAll());
        grid.setColumns("firstname", "lastname", "email");
        FormPerson formPerson = new FormPerson(personService);

        add(grid, formPerson);
    }


}
