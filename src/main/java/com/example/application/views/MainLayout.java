package com.example.application.views;

import com.example.application.infrastructure.security.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;

import javax.swing.text.html.ListView;

@Route("")
public class MainLayout extends AppLayout {
    private final SecurityService securityService;

    public MainLayout(SecurityService securityService) {
        this.securityService = securityService;
        createHeader();
    }

    private void createHeader() {
        H1 logo = new H1("Vaadin CRM");
        logo.addClassNames("text-l", "m-m");

        Button logout = new Button("Log out", e -> securityService.logout());

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, logout);

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");
        TextField textField = new TextField();
        textField.setPlaceholder("Put your name.. ");
        Button button = new Button("send");
        button.addClickListener(click -> Notification.show("Hello: " + textField.getValue()));

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(textField, button);
        horizontalLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.BASELINE);
        Anchor buttonAnchor = new Anchor();
        Anchor contactAnchor = new Anchor();
        Anchor print = new Anchor();
        buttonAnchor.setHref("about");
        buttonAnchor.setText("About");

        print.setHref("print");
        print.setText("Print");

        buttonAnchor.setTarget("_blanker");
        contactAnchor.setHref("contact");
        contactAnchor.setText("contact");

        addToNavbar(horizontalLayout, buttonAnchor, print, contactAnchor);

        addToNavbar(header);

    }
}