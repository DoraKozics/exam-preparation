package com.example.exampreparation.controller;

import com.example.exampreparation.dto.incoming.CreateBookCommand;
import com.example.exampreparation.dto.outgoing.BookListItem;
import com.example.exampreparation.dto.outgoing.InitBookFormData;
import com.example.exampreparation.service.LibraryService;
import com.example.exampreparation.validator.BookValidator;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);

    private final LibraryService libraryService;

    private final BookValidator bookValidator;

    @Autowired
    public LibraryController(LibraryService libraryService, BookValidator bookValidator) {
        this.libraryService = libraryService;
        this.bookValidator = bookValidator;
    }

    @InitBinder("createBookCommand")
    protected void initBookBinder(WebDataBinder binder) {
        binder.addValidators(bookValidator);
    }

    @GetMapping("/initBookForm")
    public ResponseEntity<InitBookFormData> getInitBookFormData() {
        InitBookFormData data = libraryService.getInitBookFormData();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Void> createBook(@RequestBody @Valid CreateBookCommand command) {
        libraryService.createMovie(command);
        logger.info("New book added");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookListItem>> getAllBooks() {
        List<BookListItem> bookList = libraryService.getAllBooks();
        logger.info("Book List requested");
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
}
