package com.mandiwal.test.data.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Question {

    @JsonProperty("question_id")
    Integer questionId;

    @JsonProperty("question")
    String question;

    @JsonProperty("answers")
    List<Answer> answers;

    public Boolean isCorrectAnswer(Integer answerId) {
        return answers.stream().anyMatch(answer -> answer.getAnswerId().equals(answerId) && answer.getIsCorrect());
    }
}
