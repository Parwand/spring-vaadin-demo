package com.example.application.views;

import com.example.application.applicationservice.service.UserService;
import com.example.application.applicationservice.service.VideoSetService;
import com.example.application.domain.model.User;
import com.example.application.domain.model.UserGroup;
import com.example.application.domain.model.VideoSet;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Date;

@Route(value = "/videos", layout = MainLayout.class)
@PageTitle("Contact")
public class VideoSetCrudView extends VerticalLayout {
    public static final String VIEW_NAME = "VideoSetCrud";

    private final Grid<VideoSet> grid;
    private final UserService userService;
    private final VideoSetService videoSetService;

    private final TextField filterByName = new TextField();
    private final Button addNew = new Button(new Icon(VaadinIcon.PLUS), this::addNew);
    private final Button edit = new Button(new Icon(VaadinIcon.EDIT), this::edit);
    private final Button remove = new Button(new Icon(VaadinIcon.TRASH), this::remove);



    public VideoSetCrudView(VideoSetService videoSetService, UserService userService) {
        this.userService = userService;
        this.videoSetService = videoSetService;
        grid = new Grid<>(VideoSet.class);
        configureGrid();
        add(grid);
    }

    private void configureGrid() {
        grid.setItems(videoSetService.findAll());
        grid.removeColumnByKey("date");
        grid.removeColumnByKey("title");
        grid.removeColumnByKey("filename");
        grid.removeColumnByKey("user");
        grid.removeColumnByKey("userGroup");
        grid.removeColumnByKey("mimeType");
        grid.removeColumnByKey("persisted");
        grid.removeColumnByKey("transcoded");
        grid.removeColumnByKey("videoSetId");

        grid.addColumn(vs -> {
            Date date = vs.getDate();
            return date;
        }).setHeader("Date");

        grid.addColumn(vs -> {
            String title = vs.getTitle();
            return title;
        }).setHeader("Title");

        grid.addColumn(vs -> {
            String filename = vs.getFilename();
            return filename;
        }).setHeader("Original Filename");

        grid.addColumn(vs -> {
            UserGroup userGroup = vs.getUserGroup();
            return userGroup;
        }).setHeader("User Group");

        grid.addColumn(vs -> {
            User user = vs.getUser();
            return user;
        }).setHeader("Uploaded By");

        grid.addColumn(vs -> {
            Boolean isExternal = vs.isIsExternal();
            return isExternal? "no": "yes";
        }).setHeader("Publicly available on internet");

        grid.addColumn(vs -> {
            Boolean isTrans = vs.isTranscoded();
            return isTrans? "OK": "X";
        }).setHeader("Transcoding Status");

        grid.addColumn(vs -> {
            Boolean isDeleted = vs.isDeleted();
            return isDeleted ? "Y": "X";
        }).setHeader("Deleted");

        filterByName.setPlaceholder("Filter By Name");
        add(new HorizontalLayout(filterByName, addNew, edit, remove));
    }

    private void addNew(ClickEvent event) {
        UI.getCurrent().navigate("upload");
    }

    private void edit(ClickEvent event) {
    }

    private void remove(ClickEvent event) {
    }
}
