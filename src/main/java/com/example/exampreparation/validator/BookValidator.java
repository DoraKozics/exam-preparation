package com.example.exampreparation.validator;

import com.example.exampreparation.domain.Book;
import com.example.exampreparation.dto.incoming.CreateBookCommand;
import com.example.exampreparation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator {

    private final BookRepository bookRepository;

    @Autowired
    public BookValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return CreateBookCommand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateBookCommand command = (CreateBookCommand) target;

        Integer year = command.getYear();
        String title = command.getTitle();
        String author = command.getAuthor();
        Book book = bookRepository.findByTitleAndAuthor(title, author);

        if (book != null) {
            errors.rejectValue("author", "book.already.exists");
        }

        if (year < 1000 || year > 2024) {
            errors.rejectValue("year", "year.not.valid");
        }
    }
}
