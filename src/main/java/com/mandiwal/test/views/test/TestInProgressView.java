package com.mandiwal.test.views.test;

import com.mandiwal.test.data.QuestionManager;
import com.mandiwal.test.data.pojo.Answer;
import com.mandiwal.test.data.pojo.Question;
import com.mandiwal.test.views.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.util.concurrent.atomic.AtomicReference;

@PageTitle("Test in progress")
@Route(value = "/testInProgress", layout = MainLayout.class)
@RouteAlias(value = "/testInProgress", layout = MainLayout.class)
public class TestInProgressView extends VerticalLayout {

    private final QuestionManager questionManager;
    private RadioButtonGroup<Answer> answerOptions;

    public TestInProgressView(QuestionManager questionManager) {
        this.questionManager = questionManager;
        questionManager.refresh();
        loadView();
    }

    private void loadView() {
        removeAll();

        AtomicReference<Question> question = new AtomicReference<>(questionManager.getNextQuestion());
        Text questionCounterText = new Text(String.format("Question %d of %d", questionManager.getQuestionCounter(), questionManager.getTotalQuestionsCount()));

        setMargin(true);

        add(questionCounterText);
        add(new Hr());


        answerOptions = new RadioButtonGroup<>();
        answerOptions.setLabel(question.get().getQuestion());
        answerOptions.setItems(question.get().getAnswers());
        answerOptions.setItemLabelGenerator(Answer::getAnswer);
        add(answerOptions);


        if (questionManager.isLastQuestion()) {
            Button finishButton = new Button("Finish Test", event -> {
                questionManager.evaluateAnswer(answerOptions.getValue().getAnswerId());
                loadFinishView();
            });

            add(finishButton);
        } else {
            Button nextButton = new Button("Next Question", event -> {
                questionManager.evaluateAnswer(answerOptions.getValue().getAnswerId());
                loadView();
            });

            add(nextButton);
        }
    }

    private void loadFinishView() {
        removeAll();
        Text resultText = new Text(String.format("Congrats for finishing the test. Your score is %d out of %d", questionManager.getCorrectAnswersCount(), questionManager.getTotalQuestionsCount()));
        add(resultText);
    }


}
