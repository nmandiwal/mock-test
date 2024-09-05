package com.mandiwal.test.data;

import lombok.Getter;

@Getter
public enum Chapter {
    NCERT_6_SCIENCE_1("NCERT Class 6 Chapter 1", "ncert/6/science/1.json", "Components of Food"),
    NCERT_6_SCIENCE_2("NCERT Class 6 Chapter 2", "ncert/6/science/2.json", "Sorting Materials into Groups"),
    NCERT_6_SCIENCE_3("NCERT Class 6 Chapter 3", "ncert/6/science/3.json", "Separation of Substances"),
    NCERT_6_SCIENCE_4("NCERT Class 6 Chapter 4", "ncert/6/science/4.json", "Getting to Know Plants"),
    NCERT_6_SCIENCE_5("NCERT Class 6 Chapter 5", "ncert/6/science/5.json", "Body Movements"),
    NCERT_6_SCIENCE_6("NCERT Class 6 Chapter 6", "ncert/6/science/6.json", "The Living Organisms - Characteristics and Habitats"),
    NCERT_6_SCIENCE_7("NCERT Class 6 Chapter 7", "ncert/6/science/7.json", "Motion and Measurement of Distances"),
    NCERT_6_SCIENCE_8("NCERT Class 6 Chapter 8", "ncert/6/science/8.json", "Light, Shadows and Reflections"),
    NCERT_6_SCIENCE_9("NCERT Class 6 Chapter 9", "ncert/6/science/9.json", "Electricity and Circuits"),
    NCERT_6_SCIENCE_10("NCERT Class 6 Chapter 10", "ncert/6/science/10.json", "Fun with Magnets"),
    NCERT_6_SCIENCE_11("NCERT Class 6 Chapter 11", "ncert/6/science/11.json", "Air Around us");

    private final String displayText;
    private final String fileName;
    private final String summary;

    Chapter(String displayText, String fileName, String summary) {
        this.displayText = displayText;
        this.fileName = fileName;
        this.summary = summary;
    }

}
