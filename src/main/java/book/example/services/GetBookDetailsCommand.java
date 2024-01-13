package book.example.services;

import book.example.models.Book;
import book.example.models.TableOfContents;
import org.springframework.stereotype.Component;

@Component
public class GetBookDetailsCommand implements BookCommand<Book> {

    @Override
    public Book execute() {
        return new Book("Carte", new TableOfContents(155L));
    }
}
