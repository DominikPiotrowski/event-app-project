package com.eventapp.gui;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Login extends VerticalLayout {
    LoginForm component = new LoginForm();

//    component.addLoginListener(e ->
//    {
//        boolean isAuthenticated = authenticate(e);
//        if (isAuthenticated) {
//            navigateToMainPage();
//        } else {
//            component.setError(true);
//        }
//    });

}
