package com.example.spproject.controllers;

import book.example.models.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
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
//        BooksStatistics stats = new BooksStatistics();
//        cap1.accept(stats);
//        stats.printStatistics();
//        return new ResponseEntity<>("", HttpStatus.OK);
//    }

    private List<Book> books = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        // Return all the books
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        // Find the book by ID
        Book foundBook = findBookById(id);
        if (foundBook != null) {
            return new ResponseEntity<>(foundBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book newBook) {
        // Create a new book
        books.add(newBook);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> replaceBook(@PathVariable("id") int id, @RequestBody Book updatedBook) {
        // Find the book by ID
        Book foundBook = findBookById(id);
        if (foundBook != null) {
            // Replace the book
            int index = books.indexOf(foundBook);
            books.set(index, updatedBook);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
        // Find the book by ID
        Book foundBook = findBookById(id);
        if (foundBook != null) {
            // Delete the book
            books.remove(foundBook);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private Book findBookById(int id) {
        // Find book by ID
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
