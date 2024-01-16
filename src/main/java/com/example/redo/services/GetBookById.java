package com.example.redo.services;

import com.example.redo.models.Book;
import org.springframework.stereotype.Component;

@Component
public class GetBookById implements Command<Book>{

    private final BookService bookService;
    private Long id;

    public GetBookById(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Book execute() {
        return bookService.getBookById(id);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
