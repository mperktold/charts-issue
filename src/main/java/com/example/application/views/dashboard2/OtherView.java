package com.example.application.views.dashboard2;


import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Other View")
@Menu(order = 1)
@Route(value = "other")
public class OtherView extends Main {

    public OtherView() {
        add(new Text("Other view"));
    }

}
