package book.example.services;


import book.example.models.Book;
import book.example.models.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteBookCommand implements BookCommand<Book>{
    private final BookRepository bookRepository;
    private Book book;

    public DeleteBookCommand(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    @Override
    public Book execute() {
        if (book != null) {

            bookRepository.deleteById(book.getId());
            return book;
        } else {
            return null;
        }
    }
}
