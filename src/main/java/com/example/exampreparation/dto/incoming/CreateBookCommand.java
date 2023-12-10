package com.example.exampreparation.dto.incoming;

import com.example.exampreparation.domain.GenreType;
import com.example.exampreparation.domain.LanguageType;

import java.util.ArrayList;
import java.util.List;

public class CreateBookCommand {

    private String title;

    private String author;

    private Integer year;

    private List<GenreType> genres = new ArrayList<>();

    private LanguageType language;

    private String coverUrl;

    public CreateBookCommand() {
    }

    public CreateBookCommand(String title, String author, Integer year, List<GenreType> genres, LanguageType language, String coverUrl) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genres = genres;
        this.language = language;
        this.coverUrl = coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<GenreType> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreType> genres) {
        this.genres = genres;
    }

    public LanguageType getLanguage() {
        return language;
    }

    public void setLanguage(LanguageType language) {
        this.language = language;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}
