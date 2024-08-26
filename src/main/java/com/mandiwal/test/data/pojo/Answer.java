package com.mandiwal.test.data.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Answer {
    @JsonProperty("answer_id")
    private Integer answerId;

    @JsonProperty("answer")
    private String answer;

    @JsonProperty("is_correct_answer")
    private Boolean isCorrect;
}
