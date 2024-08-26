package com.mandiwal.test.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mandiwal.test.data.pojo.Question;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.util.List;

import static java.util.Collections.shuffle;

@Component
@Getter
@UIScope
public class QuestionManager {
    private Integer correctAnswersCount = 0;
    private Integer questionCounter = 0;
    private List<Question> questions = null;

    @SneakyThrows
    private List<Question> getQuestions() {
        if (questions == null) {
            ObjectMapper mapper = new ObjectMapper();
            List<Question> allQuestions = mapper.readValue(ResourceUtils.getFile("classpath:class_6_science.json"), new TypeReference<List<Question>>() {
            });
            shuffle(allQuestions);
            questions = allQuestions.subList(0, 5);
        }
        return questions;
    }

    public Question getNextQuestion() {
        questionCounter++;
        return getQuestions().get(questionCounter - 1);
    }

    public void evaluateAnswer(Integer selectedAnswerId) {
        if (getCurrentQuestion().isCorrectAnswer(selectedAnswerId)) {
            ++correctAnswersCount;
        }
    }

    private Question getCurrentQuestion() {
        return getQuestions().get(questionCounter - 1);
    }

    public Integer getTotalQuestionsCount() {
        return getQuestions().size();
    }

    public boolean isLastQuestion() {
        return getQuestions().size() == questionCounter;
    }

    public void refresh() {
        correctAnswersCount = 0;
        questionCounter = 0;
        questions = null;
    }
}
