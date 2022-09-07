package com.example.application.domain.form;

import com.example.application.applicationservice.service.UserService;
import com.example.application.domain.model.User;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;


public class UserForm extends FormLayout {
    UserService userService;
    TextField firstname = new TextField("firstname");
    TextField lastname  = new TextField("lastname");
    TextField email     = new TextField("email");
    TextField role     = new TextField("role");
    Binder<User> binder = new Binder<>(User.class);
    User user = new User();

    public UserForm(UserService userService) {
        this.userService = userService;
        binder.bindInstanceFields(this);



        Button saveButton = new Button("save");
        saveButton.addClickListener(buttonClickEvent -> {
            user.setFirstName(firstname.getValue());
            user.setLastName(lastname.getValue());
            user.setEmail(email.getValue());
            user.setRole(role.getValue());
            userService.save(user);
        });
        add(firstname, lastname, email, role, saveButton);
    }
}
