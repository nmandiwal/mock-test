package com.mandiwal.test.data;

import lombok.Getter;

@Getter
public enum Chapter {
    CBSE_6_SCIENCE_1("CBSE Class 6 Chapter 1", "cbse/6/1.json", "Components of Food"),
    CBSE_6_SCIENCE_2("CBSE Class 6 Chapter 2", "cbse/6/2.json", "Sorting Materials into Groups"),
    CBSE_6_SCIENCE_3("CBSE Class 6 Chapter 3", "cbse/6/3.json", "Separation of Substances"),
    CBSE_6_SCIENCE_4("CBSE Class 6 Chapter 4", "cbse/6/4.json", "Getting to Know Plants"),
    CBSE_6_SCIENCE_5("CBSE Class 6 Chapter 5", "cbse/6/5.json", "Body Movements");

    private final String displayText;
    private final String fileName;
    private final String summary;

    Chapter(String displayText, String fileName, String summary) {
        this.displayText = displayText;
        this.fileName = fileName;
        this.summary = summary;
    }

}
