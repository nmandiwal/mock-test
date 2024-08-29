package com.mandiwal.test.views.test;

import com.mandiwal.test.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Home")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HomePageView extends VerticalLayout {


    public HomePageView() {
        Button selectTestButton = new Button("Select Test");
        selectTestButton.addClickListener(e -> selectTestButton.getUI().ifPresent(ui -> ui.navigate("select")));
        selectTestButton.addClickShortcut(Key.ENTER);
        add(selectTestButton);

        Button aboutButton = new Button("About");
        aboutButton.addClickListener(e -> aboutButton.getUI().ifPresent(ui -> ui.navigate("about")));
        aboutButton.addClickShortcut(Key.ENTER);
        add(aboutButton);

        setMargin(true);

    }

}
