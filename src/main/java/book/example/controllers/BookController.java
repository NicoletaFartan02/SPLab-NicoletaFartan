package book.example.controllers;

import book.example.models.Book;
import book.example.services.BookService;
import book.example.services.GetBookDetailsCommand;
import book.example.services.GetBooksCommand;
import book.example.services.UpdateBookCommand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController()
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/")
    public List<Book> getBooks() {
        var command = new GetBooksCommand();
        return command.execute();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        System.out.println("search by id: " + id);
        return new Book("O carte");
    }

    @PostMapping("/")
    public Book createBook(@RequestBody Book book) {
        var command = new UpdateBookCommand(book, this.bookService);
        return command.execute();
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable int id) {
        System.out.println("Update by id: " + id);
        return new Book(book.getTitle());
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteBook(@PathVariable int id) {
        System.out.println("Delete by id: " + id);
        return HttpStatus.OK;
    }
    
}
