package book.example.services;


import book.example.models.Book;
import org.springframework.stereotype.Component;

@Component
public class UpdateBookCommand implements BookCommand<Book> {
    private final Book newBook;
    private final BookService bookService;

    public UpdateBookCommand(Book newBook, BookService bookService) {
        this.newBook = newBook;
        this.bookService = bookService;
    }
    @Override
    public Book execute() {
        return this.bookService.updateBook(this.newBook.getId(),this.newBook);
    }
}
