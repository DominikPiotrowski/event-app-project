package com.eventapp.gui;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Route("login")
public class Login extends VerticalLayout implements BeforeEnterObserver {

    @PersistenceContext
    private EntityManager entityManager;
    boolean session = true;

    public Login() {
        TextField username = new TextField("Username");
        PasswordField password = new PasswordField("Password");
        Button loginButton = new Button("Login");

        loginButton.addClickListener((ComponentEventListener<ClickEvent<Button>>)
                buttonClickEvent -> doLogin(username.getValue(), password.getValue()));

        loginButton.getElement().setAttribute("theme", "primary");
        HorizontalLayout buttonsLayout = new HorizontalLayout(loginButton);
        VerticalLayout divLayout = new VerticalLayout(username, password, buttonsLayout);
        divLayout.setAlignSelf(Alignment.END, buttonsLayout);
        Div loginDiv = new Div(divLayout);
        setAlignItems(Alignment.CENTER);
        username.focus();
        add(loginDiv);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (session == true) {
            beforeEnterEvent.forwardTo(Search.class);
        } else {
            beforeEnterEvent.rerouteTo(IncorrectLogin.class);
        }
    }

    //TODO
    private Object doLogin(String value, String value1) {
        return null;
    }
}