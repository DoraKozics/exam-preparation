package com.example.exampreparation.domain;

public enum GenreType {
    ACTION("Action"),
    ADVENTURE("Adventure"),
    BIOGRAPHY("Biography"),
    COMIC_BOOK("Comic Book"),
    FANTASY("Fantasy"),
    HORROR("Horror"),
    MYSTERY("Mystery"),
    ROMANCE("Romance"),
    SCI_FI("Sci-Fi");

    String displayName;

    GenreType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
