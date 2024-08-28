package com.mandiwal.test.data.pojo;


import lombok.Data;

import java.util.Set;

@Data
public class Question {

    //    @JsonProperty("question_id")
    Integer questionId;
    Integer answerId;

    //    @JsonProperty("question")
    String question;

    //    @JsonProperty("options")
    Set<Option> options;

    public Boolean isCorrectAnswer(Integer optionId) {
        return answerId.equals(optionId);
    }
}
