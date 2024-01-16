package com.example.redo.controllers;

import com.example.redo.models.*;
import com.example.redo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/books")
public class BookController {
    List<Request<?>> requests;
    CommandExecutor syncCommandExecutor;
    CommandExecutor asyncCommandExecutor;
    ExecutorService executorService;
    @Autowired
    BookService bookService;
    @Autowired
    private AllBooksSubject allBooksSubject;
    private List<Book> books = new ArrayList<>();
    private final GetBooks getBooks;
    private final GetBookById getBookById;
    private final UpdateBook updateBook;
    private final DeleteBook deleteBooks;
    private final AddBook addBooks;
    public BookController(GetBooks getBooks, GetBookById getBookById, UpdateBook updateBook, DeleteBook deleteBooks, AddBook addBooks){
        this.getBooks = getBooks;
        this.getBookById = getBookById;
        this.updateBook = updateBook;
        this.deleteBooks = deleteBooks;
        this.addBooks = addBooks;
        this.requests = new ArrayList<>();
        this.asyncCommandExecutor = new AsynchronousExecutor();
        this.executorService = Executors.newFixedThreadPool(2);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::processRequests, 0, 10, TimeUnit.SECONDS);
    }
    public void processRequests() {
        System.out.println("Processing requests");

        for (Request request : requests) {
            if (!request.isCompleted()) {
                executorService.submit(() -> {
                    System.out.println("Executing request " + request.getId());

                    request.setResult(request.getCommand().execute());
                    request.setCompleted(true);

                    System.out.println("Request " + request.getId() + " completed");
                });
            }
        }}


//    @GetMapping("/statistics")
//    public ResponseEntity<?> printStatistics() {
//        Section cap1 = new Section("Capitolul 1");
//        Paragraph p1 = new Paragraph("Paragraph 1");
//        cap1.add(p1);
//        Paragraph p2 = new Paragraph("Paragraph 2");
//        cap1.add(p2);
//        Paragraph p3 = new Paragraph("Paragraph 3");
//        cap1.add(p3);
//        Paragraph p4 = new Paragraph("Paragraph 4");
//        cap1.add(p4);
//        cap1.add(new ImageProxy("ImageOne"));
//        cap1.add(new Image("ImageTwo"));
//        cap1.add(new Paragraph("Some text"));
//        cap1.add(new Table("Table 1"));
//        BookStatistics stats = new BookStatistics();
//        cap1.accept(stats);
//        stats.printStatistics();
//        return new ResponseEntity<>("", HttpStatus.OK);
//    }

    @GetMapping
    public List<Book> getBooks()
    {
        return getBooks.execute();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        this.getBookById.setId(id);
        return getBookById.execute();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) throws IOException {
        addBooks.setAttribute(book);
        addBooks.execute();
        allBooksSubject.add(book);
        Request request = asyncCommandExecutor.executeCommand(addBooks, bookService);
        request.setId(requests.size());
        requests.add(request);
        return book;
    }
    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        this.updateBook.setAttribute(id,book);
        return this.updateBook.execute();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        this.deleteBooks.setAttribute(id);
        this.deleteBooks.execute();

    }




}
