package com.mandiwal.test.views.test;

import com.mandiwal.test.data.Chapter;
import com.mandiwal.test.data.QuestionManager;
import com.mandiwal.test.data.pojo.Option;
import com.mandiwal.test.data.pojo.Question;
import com.mandiwal.test.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.*;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicReference;

import static com.vaadin.flow.component.radiobutton.RadioGroupVariant.LUMO_VERTICAL;

@Route(value = "/test", layout = MainLayout.class)
@RouteAlias(value = "/test", layout = MainLayout.class)
public class TestView extends VerticalLayout implements HasUrlParameter<String> {

    private final QuestionManager questionManager;
    @Getter
    private String pageTitle;
    private Chapter chapter;
    private RadioButtonGroup<Option> answerOptions;


    public TestView(QuestionManager questionManager) {
        this.questionManager = questionManager;
    }

    @Override
    public void setParameter(BeforeEvent event, @WildcardParameter String chapterString) {
        chapter = Chapter.valueOf(chapterString);
        questionManager.refresh(chapter);
        pageTitle = chapter.getDisplayText();
        loadStartView();
    }

    private void loadStartView() {
        removeAll();
        add(new H4(chapter.getSummary()));

        Button start = new Button("Start Test");
        start.addClickListener(e -> loadInProgressView());

        start.addClickShortcut(Key.ENTER);

        setMargin(true);
        //setVerticalComponentAlignment(Alignment.END, start);

        add(start);
    }

    private void loadInProgressView() {
        removeAll();
        add(new H4(chapter.getSummary()));
        AtomicReference<Question> question = new AtomicReference<>(questionManager.getNextQuestion());
        Text questionCounterText = new Text(String.format("Question %d of %d", questionManager.getQuestionCounter(), questionManager.getTotalQuestionsCount()));

        setMargin(true);

        add(questionCounterText);
        add(new Hr());


        answerOptions = new RadioButtonGroup<>();
        answerOptions.setLabel(question.get().getQuestion());
        answerOptions.setItems(question.get().getOptions());
        answerOptions.setItemLabelGenerator(Option::getOption);
        answerOptions.addThemeVariants(LUMO_VERTICAL);
        add(answerOptions);

        if (questionManager.isLastQuestion()) {
            Button finishButton = new Button("Finish Test", event -> {
                questionManager.evaluateAnswer(answerOptions.getValue().getOptionId());
                loadFinishView();
            });
            finishButton.setEnabled(false);
            answerOptions.addValueChangeListener(event -> finishButton.setEnabled(event.getValue() != null));
            add(finishButton);
        } else {
            Button nextButton = new Button("Next Question", event -> {
                questionManager.evaluateAnswer(answerOptions.getValue().getOptionId());
                loadInProgressView();
            });
            nextButton.setEnabled(false);
            answerOptions.addValueChangeListener(event -> nextButton.setEnabled(event.getValue() != null));

            add(nextButton);
        }

    }

    private void loadFinishView() {
        removeAll();
        add(new H4(chapter.getSummary()));
        Text resultText1 = new Text("Congrats for finishing the test. ");
        Text resultText2 = new Text(String.format("Your score is %d out of %d.", questionManager.getCorrectAnswersCount(), questionManager.getTotalQuestionsCount()));
        add(resultText1, new H4(""), resultText2);
    }

}
