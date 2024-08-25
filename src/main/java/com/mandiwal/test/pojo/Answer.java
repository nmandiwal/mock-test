package com.mandiwal.test.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Answer {
    @JsonProperty("answer_id")
    private int answerId;

    @JsonProperty("answer")
    private String answer;

    @JsonProperty("is_correct_answer")
    private Boolean isCorrectAnswer;
}
