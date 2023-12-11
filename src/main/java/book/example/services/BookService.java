package book.example.services;

import book.example.models.Book;
import org.springframework.stereotype.Component;

@Component
public class BookService {
    public Book saveBook(Book newBook) {
        System.out.println("Salvam cartea");
        return newBook;
    }
}
