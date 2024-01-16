package com.example.redo.services;

import com.example.redo.models.Book;
import org.springframework.stereotype.Component;

@Component
public class DeleteBook implements Command<Void>{

    private Book book;
    private final BookService bookService;
    private Long Id;

    public DeleteBook(BookService bookService) {
        this.bookService = bookService;
    }


    @Override
    public Void execute() {
        bookService.delete(Id);
        return null;
    }
    public void setAttribute(Long id){
        this.Id = id;
    }
}
