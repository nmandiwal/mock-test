package com.mandiwal.test.data;

import lombok.Getter;

@Getter
public enum Chapter {
    CBSE_6_SCIENCE_1("CBSE Class 6 Chapter 1", "class_6_science_chapter_1.json", "Components of Food"),
    CBSE_6_SCIENCE_2("CBSE Class 6 Chapter 2", "class_6_science_chapter_2.json", "Sorting Materials into Groups");

    private final String displayText;
    private final String fileName;
    private final String summary;

    Chapter(String displayText, String fileName, String summary) {
        this.displayText = displayText;
        this.fileName = fileName;
        this.summary = summary;
    }

}
