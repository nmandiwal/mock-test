package com.mandiwal.test.views.test;

import com.mandiwal.test.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Start test")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class TestStartView extends HorizontalLayout {

    private Button start;

    public TestStartView() {
        start = new Button("Start Test");
        start.addClickListener(e -> start.getUI().ifPresent(ui -> ui.navigate("testInProgress")));

        start.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, start);

        add(start);
    }

}
