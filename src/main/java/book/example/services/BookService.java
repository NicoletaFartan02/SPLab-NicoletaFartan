package book.example.services;

import book.example.models.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import book.example.models.Book;
import book.example.persistence.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
//    public Book saveBook(Book newBook) {
//        System.out.println("Salvam cartea");
//        return newBook;
//    }
private final BooksRepository booksRepository;

    @Autowired
    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Book getBookById(int id) {
        Optional<Book> optionalBook = booksRepository.findById((long) id);
        return optionalBook.orElse(null);
    }

    public Book createBook(Book book) {
        return booksRepository.save(book);
    }

    public Book updateBook(long id, Book book) {

        if (booksRepository.existsById((long) id)) {
            book.setId((long) id);
            return booksRepository.save(book);
        }
        return null;
    }

    public void deleteBook(int id) {
        booksRepository.deleteById((long) id);
    }
}
