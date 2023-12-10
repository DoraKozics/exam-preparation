package com.example.exampreparation.domain;

public enum LanguageType {
    ENGLISH("English"),
    FRENCH("French"),
    GERMAN("German"),
    HUNGARIAN("Hungarian"),
    ITALIAN("Italian"),
    SPANISH("Spanish"),
    OTHER("Other");

    String displayName;

    LanguageType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
