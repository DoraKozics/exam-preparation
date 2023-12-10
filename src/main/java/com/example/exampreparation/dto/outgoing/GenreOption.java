package com.example.exampreparation.dto.outgoing;

import com.example.exampreparation.domain.GenreType;

public class GenreOption {

    private String name;

    private String displayName;

    public GenreOption() {
    }

    public GenreOption(GenreType type) {
        this.name = type.name();
        this.displayName = type.getDisplayName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
