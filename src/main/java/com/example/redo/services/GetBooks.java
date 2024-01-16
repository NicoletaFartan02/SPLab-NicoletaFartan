package com.example.redo.services;

import com.example.redo.models.Book;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GetBooks implements Command<List<Book>>{

    private final BookService bookService;

    public GetBooks(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public List<Book> execute() {
        return bookService.getAllBooks();
    }
}

