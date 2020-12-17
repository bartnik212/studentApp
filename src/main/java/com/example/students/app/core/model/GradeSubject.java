package com.example.students.app.core.model;

import lombok.Data;

public enum GradeSubject {

    BIOLOGY("Biology"),
    MATHEMATICS("Mathematics"),
    SPANISH_LANGUAGE("Spanish Language"),
    ENGLISH_LANGUAGE("English Language"),
    PHYSICS("Physics");

    private String name;

    GradeSubject(String name) {
        this.name = name();
    }

    public String getName() {
        return name;
    }
}
