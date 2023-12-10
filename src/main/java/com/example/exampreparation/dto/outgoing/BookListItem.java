package com.example.exampreparation.dto.outgoing;

import com.example.exampreparation.domain.Book;
import com.example.exampreparation.domain.GenreType;

import java.util.List;

public class BookListItem {

    private Long id;

    private String title;

    private String author;

    private Integer year;

    private List<String> genres;

    private String language;

    public BookListItem() {
    }

    public BookListItem(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.year = book.getYear();
        this.genres = book.getGenres().stream().map(GenreType::getDisplayName).toList();
        this.language = book.getLanguage().getDisplayName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
