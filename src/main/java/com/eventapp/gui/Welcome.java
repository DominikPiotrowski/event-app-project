package com.eventapp.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("welcome")
public class Welcome extends VerticalLayout {

    public Welcome() {
        Label welcome = new Label("Welcome to iventApp");
        Button loginButton = new Button("Login", new Icon(VaadinIcon.ENTER_ARROW));
        Button registerButton = new Button("Register", new Icon(VaadinIcon.ENTER_ARROW));

        loginButton.addClickListener(e -> {
            loginButton.getUI().ifPresent(ui -> ui.navigate("login"));
        });

        registerButton.addClickListener(e -> {
            registerButton.getUI().ifPresent(ui -> ui.navigate("login"));
        });
        
        add(welcome, loginButton, registerButton);
    }
}