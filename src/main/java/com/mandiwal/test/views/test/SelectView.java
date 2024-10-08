package com.mandiwal.test.views.test;

import com.mandiwal.test.data.Chapter;
import com.mandiwal.test.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Select Test")
@Route(value = "/select", layout = MainLayout.class)
@RouteAlias(value = "/select", layout = MainLayout.class)
public class SelectView extends VerticalLayout {

    public SelectView() {
        for (Chapter value : Chapter.values()) {
            Button button = new Button(value.getDisplayText());
            button.addClickListener(e -> button.getUI().ifPresent(ui -> ui.navigate("test/" + value)));
            button.addClickShortcut(Key.ENTER);
            //setVerticalComponentAlignment(Alignment.END, button);
            add(button);
        }
    }
}
