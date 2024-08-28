package com.mandiwal.test.views.test;

import com.mandiwal.test.data.Chapter;
import com.mandiwal.test.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Select test")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HomePageView extends HorizontalLayout {


    public HomePageView() {
        for (Chapter value : Chapter.values()) {
            Button button = new Button(value.getDisplayText());
            button.addClickListener(e -> button.getUI().ifPresent(ui -> ui.navigate("testInProgress/" + value)));
            button.addClickShortcut(Key.ENTER);


            setVerticalComponentAlignment(Alignment.END, button);

            add(button);
        }
        setMargin(true);

    }

}
