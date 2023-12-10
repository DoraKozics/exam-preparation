package com.example.exampreparation.domain;

import com.example.exampreparation.dto.incoming.CreateBookCommand;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "year")
    private Integer year;

    @Enumerated(EnumType.STRING)
    @Column(name = "genres")
    private List<GenreType> genres;

    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    private LanguageType language;

    @OneToMany(mappedBy = "book")
    private List<Borrowing> borrowings = new ArrayList<>();

    @Column(name = "cover_url")
    private String coverUrl;

    public Book() {
    }

    public Book(CreateBookCommand command) {
        this.title = command.getTitle();
        this.author = command.getAuthor();
        this.year = command.getYear();
        this.genres = command.getGenres();
        this.language = command.getLanguage();
        this.coverUrl = command.getCoverUrl();
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

    public List<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}
