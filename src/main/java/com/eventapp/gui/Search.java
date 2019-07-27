package com.eventapp.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;



@Route("search-event-form")
public class Search extends FormLayout {

    private TextField name = new TextField("Name");
    private TextField city = new TextField("City");
    private TextField country = new TextField("Country");
    DatePicker startDate = new DatePicker();
    DatePicker endDate = new DatePicker();
    private Button submit = new Button("Submit");
    private Button clear = new Button("Clear");

    public Search() {
        setSizeUndefined();
        HorizontalLayout buttons = new HorizontalLayout(submit, clear);
        startDate.setLabel("Select start date");
        endDate.setLabel("Select end date");
        add(name, city, country, startDate, endDate);

    }

    //TODO jak przekazać te parametry do API??
}