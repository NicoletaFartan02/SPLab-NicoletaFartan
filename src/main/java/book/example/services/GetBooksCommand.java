package book.example.services;

import book.example.models.Book;

import java.util.List;

public class GetBooksCommand implements BookCommand<List<Book>>{
    @Override
    public List<Book> execute() {
        return List.of(new Book("Cartea1"));
    }
}
