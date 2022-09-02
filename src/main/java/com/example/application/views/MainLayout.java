package com.example.application.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Home Page")
@Route(value = "")
public class MainLayout extends VerticalLayout {

    public MainLayout() {
        TextField textField = new TextField();
        textField.setPlaceholder("Put your name.. ");
        Button button = new Button("send");
        button.addClickListener(click ->Notification.show("Hello: " + textField.getValue()));

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(textField, button);
        horizontalLayout.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        Anchor anchor = new Anchor();
        Anchor contactAnchor = new Anchor();
        anchor.setHref("about");
        anchor.setText("About");
        anchor.setTarget("_blanker");
        contactAnchor.setHref("contact");
        contactAnchor.setText("contact");

        add(horizontalLayout, anchor, contactAnchor);
    }
}
