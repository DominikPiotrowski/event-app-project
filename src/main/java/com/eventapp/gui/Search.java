package com.eventapp.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;

@Route("search-event-form")
public class Search extends FormLayout {

    private TextField name = new TextField("Name");
    private TextField city = new TextField("City");
    private TextField country = new TextField("Country");

    private DateField date = new DateField();
    date.setValue(LocalDate.now())

    private Button submit = new Button("Submit");
    private Button clear = new Button("Clear");

    public Search() {
        setSizeUndefined();
        HorizontalLayout buttons = new HorizontalLayout(submit, clear);
        add(name, city, country, buttons); //+date
    }

    //TODO jak przekazać te parametry do API??
}