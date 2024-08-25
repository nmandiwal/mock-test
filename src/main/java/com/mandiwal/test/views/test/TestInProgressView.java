package com.mandiwal.test.views.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mandiwal.test.pojo.Answer;
import com.mandiwal.test.pojo.Question;
import com.mandiwal.test.views.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import lombok.SneakyThrows;
import org.springframework.util.ResourceUtils;

import java.util.List;

@PageTitle("Test in progress")
@Route(value = "/testInProgress", layout = MainLayout.class)
@RouteAlias(value = "/testInProgress", layout = MainLayout.class)
public class TestInProgressView extends VerticalLayout {

    public TestInProgressView() {

        List<Question> questions = getQuestions();
        Text questionCounter = new Text("Question 1 of 50");
        Question question1 = questions.get(0);


        setMargin(true);

        add(questionCounter);
        add(new Hr());

        RadioButtonGroup<String> radioButtonGroup = new RadioButtonGroup<>();
        radioButtonGroup.setLabel(question1.getQuestion());
        radioButtonGroup.setItems(question1.getAnswers().stream().map(Answer::getAnswer).toList());

        add(radioButtonGroup);
    }

    @SneakyThrows
    private List<Question> getQuestions() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(ResourceUtils.getFile("classpath:class_6_science.json"), new TypeReference<List<Question>>() {
        });

    }

}
