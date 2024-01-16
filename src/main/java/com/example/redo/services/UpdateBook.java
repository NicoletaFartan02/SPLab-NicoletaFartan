package com.example.redo.services;

import com.example.redo.models.Book;
import org.springframework.stereotype.Component;

@Component
public class UpdateBook implements Command<Book> {

    private final BookService bookService;
    Long id;
    Book book;

    public UpdateBook(BookService bookService) {
        this.bookService = bookService;
    }

    public void setAttribute(Long id, Book newBook){
        this.id = id;
        this.book = newBook;
    }

    @Override
    public Book execute() {
        bookService.update(id,book);
        return bookService.getBookById(id);
    }
}
