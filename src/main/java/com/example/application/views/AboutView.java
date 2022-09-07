package com.example.application.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/about", layout = MainLayout.class)
public class AboutView extends VerticalLayout {
    H1 h1 = new H1("Parwand Alsino");

    public AboutView() {
        add(h1);
    }
}
