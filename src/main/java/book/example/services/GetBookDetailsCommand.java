package book.example.services;

import book.example.models.Book;
import org.springframework.stereotype.Component;

@Component
public class GetBookDetailsCommand implements BookCommand<Book> {

    @Override
    public Book execute() {
        return new Book("Carte");
    }
}
