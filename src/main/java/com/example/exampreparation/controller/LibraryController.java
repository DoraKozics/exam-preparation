package com.example.exampreparation.controller;

import com.example.exampreparation.dto.incoming.CreateBookCommand;
import com.example.exampreparation.dto.outgoing.InitBookFormData;
import com.example.exampreparation.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LibraryController {

    private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/initBookForm")
    public ResponseEntity<InitBookFormData> getInitBookFormData() {
        InitBookFormData data = libraryService.getInitBookFormData();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Void> createBook(@RequestBody CreateBookCommand command) {
        libraryService.createMovie(command);
        logger.info("New book added");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
