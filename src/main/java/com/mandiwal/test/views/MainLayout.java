package com.mandiwal.test.views;

import com.mandiwal.test.views.test.AboutView;
import com.mandiwal.test.views.test.HomePageView;
import com.mandiwal.test.views.test.SelectView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.lang.reflect.Field;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H1 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H1();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        Span appName = new Span("mock_test");
        appName.addClassNames(LumoUtility.FontWeight.SEMIBOLD, LumoUtility.FontSize.LARGE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Home", HomePageView.class, LineAwesomeIcon.GLOBE_SOLID.create()));
        nav.addItem(new SideNavItem("Select Test", SelectView.class, LineAwesomeIcon.GLOBE_SOLID.create()));
        nav.addItem(new SideNavItem("about", AboutView.class, LineAwesomeIcon.GLOBE_SOLID.create()));
        //nav.addItem(new SideNavItem("Hello World", HelloWorldView.class, LineAwesomeIcon.GLOBE_SOLID.create()));

        return nav;
    }

    private Footer createFooter() {
        return new Footer();
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        String titleValue = "Sample Title";
        if (title == null) {
            try {
                Field pageTitle = getContent().getClass().getDeclaredField("pageTitle");
                pageTitle.setAccessible(true);
                titleValue = (String) pageTitle.get(getContent());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // ignore
            }
        } else {
            titleValue = title.value();
        }
        return titleValue;
    }
}
