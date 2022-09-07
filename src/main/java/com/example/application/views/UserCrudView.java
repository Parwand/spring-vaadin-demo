package com.example.application.views;

import com.example.application.applicationservice.service.UserService;
import com.example.application.domain.model.User;
import com.example.application.domain.form.UserForm;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "/contact", layout = MainLayout.class)
@PageTitle("Contact")
public class UserCrudView extends VerticalLayout {
    UserService userService;

    public UserCrudView(UserService userService) {
        this.userService = userService;

        var grid = new Grid<>(User.class);
        grid.setItems(userService.findAll());
        grid.setColumns("userId", "enabled", "email", "lastName", "firstName", "role", "userGroups");
        UserForm formPerson = new UserForm(userService);

        add(grid, formPerson);
    }


}
