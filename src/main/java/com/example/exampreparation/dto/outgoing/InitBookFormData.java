package com.example.exampreparation.dto.outgoing;

import java.util.ArrayList;
import java.util.List;

public class InitBookFormData {

    private List<GenreOption> genreOptions = new ArrayList<>();

    private List<LanguageOption> languageOptions = new ArrayList<>();

    public InitBookFormData() {
    }

    public InitBookFormData(List<GenreOption> genreOptions, List<LanguageOption> languageOptions) {
        this.genreOptions = genreOptions;
        this.languageOptions = languageOptions;
    }

    public List<GenreOption> getGenreOptions() {
        return genreOptions;
    }

    public void setGenreOptions(List<GenreOption> genreOptions) {
        this.genreOptions = genreOptions;
    }

    public List<LanguageOption> getLanguageOptions() {
        return languageOptions;
    }

    public void setLanguageOptions(List<LanguageOption> languageOptions) {
        this.languageOptions = languageOptions;
    }
}
