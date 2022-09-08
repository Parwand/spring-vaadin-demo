package com.example.application.views;

import com.example.application.infrastructure.security.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

@CssImport("./themes/myapp/styles.css")
public class MainLayout extends AppLayout {
    private final SecurityService securityService;

    public MainLayout(SecurityService securityService) {
        this.securityService = securityService;
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        final HorizontalLayout top = new HorizontalLayout();
        top.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.STRETCH);
        Image image = new Image("/images/coba_logo.svg", "coba_logo");
        image.getStyle().set("StyleName", "logo");
        image.setWidth("230px");
        Label title = new Label("Video-Transkodierungstool");
        top.add(image, title);
        Button logout = new Button("Log out", e -> securityService.logout());

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), top, logout);

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(top);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");
        addToNavbar(header);

    }


    private void createDrawer() {
        RouterLink videoLink = new RouterLink("Videos", VideoSetCrudView.class);
        videoLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink aboutLink = new RouterLink("About", AboutView.class);
        aboutLink.setHighlightCondition(HighlightConditions.sameLocation());
        RouterLink contactLink = new RouterLink("Users", UserCrudView.class);
        contactLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink printLink = new RouterLink("Print", PrintLayout.class);
        printLink.setHighlightCondition(HighlightConditions.sameLocation());
        addToDrawer(new VerticalLayout(videoLink, contactLink, printLink, aboutLink));
    }
}