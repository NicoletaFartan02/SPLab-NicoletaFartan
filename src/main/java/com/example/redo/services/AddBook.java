package com.example.redo.services;

import com.example.redo.models.Book;
import org.springframework.stereotype.Component;


@Component
public class AddBook implements Command<Book> {
    private final BookService bookService;

    private Book book;

    public AddBook(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Book execute() {
        return bookService.saveBook(book);
    }

    public void setAttribute(Book newBook){
        this.book = newBook;
    }

}
