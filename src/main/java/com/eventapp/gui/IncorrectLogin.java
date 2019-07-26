package com.eventapp.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("incorrect-login")
public class IncorrectLogin extends VerticalLayout {

    public IncorrectLogin() {
        Label incorrect = new Label("Incorrect login or password");
        Button tryAgain = new Button("Try again", new Icon(VaadinIcon.ENTER_ARROW));

        tryAgain.addClickListener(e -> {
            tryAgain.getUI().ifPresent(ui -> ui.navigate("login"));
        });
        add(incorrect, tryAgain);
    }
}
