package com.mandiwal.test.views.test;

import com.mandiwal.test.views.MainLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("About")
@Route(value = "/about", layout = MainLayout.class)
@RouteAlias(value = "/about", layout = MainLayout.class)
public class AboutView extends VerticalLayout {

    public AboutView() {
        add(VaadinIcon.INFO_CIRCLE.create());
        add(new Span(" This application is created to provide CBSE mock tests."));
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
    }
}
