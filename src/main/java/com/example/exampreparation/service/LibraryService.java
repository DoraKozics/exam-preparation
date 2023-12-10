package com.example.exampreparation.service;

import com.example.exampreparation.domain.Book;
import com.example.exampreparation.domain.GenreType;
import com.example.exampreparation.domain.LanguageType;
import com.example.exampreparation.dto.incoming.CreateBookCommand;
import com.example.exampreparation.dto.outgoing.GenreOption;
import com.example.exampreparation.dto.outgoing.InitBookFormData;
import com.example.exampreparation.dto.outgoing.LanguageOption;
import com.example.exampreparation.repository.BookRepository;
import com.example.exampreparation.repository.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class LibraryService {

    private final BookRepository bookRepository;

    private final BorrowingRepository borrowingRepository;

    @Autowired
    public LibraryService(BookRepository bookRepository, BorrowingRepository borrowingRepository) {
        this.bookRepository = bookRepository;
        this.borrowingRepository = borrowingRepository;
    }

    public void createMovie(CreateBookCommand command) {
        Book book = new Book(command);
        bookRepository.save(book);
    }

    public InitBookFormData getInitBookFormData() {
        List<GenreOption> genreOptions = Arrays
                .stream(GenreType.values())
                .map(GenreOption::new)
                .toList();
        List<LanguageOption> languageOptions = Arrays
                .stream(LanguageType.values())
                .map(LanguageOption::new)
                .toList();
        return new InitBookFormData(genreOptions, languageOptions);
    }
}
