package com.example.redo.services;

import com.example.redo.models.Author;
import com.example.redo.models.Book;
import com.example.redo.models.Element;
import com.example.redo.models.Table;
import com.example.redo.repositories.AuthorsRepository;
import com.example.redo.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookService {

    private BooksRepository bookRepository;
    @Autowired
    private AuthorsRepository authorRepository;

    public BookService(BooksRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Book saveBook(Book book){
        for (Author a : book.getAuthors())
        {authorRepository.save(a);}
        book=bookRepository.save(book);
        return book;
    }
    public void delete(Long bookId)
    {
        bookRepository.deleteById(bookId);
    }
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Book update(Long bookId, Book updatedBook) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Cartea nu a fost gasita: " + bookId));

        for (Author a : updatedBook.getAuthors()) {
            authorRepository.save(a);
        }

        book.setTitle(updatedBook.getTitle());
        book.setAuthors(updatedBook.getAuthors());

        return bookRepository.save(book);
    }

    public Book getBookById(Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        return book.orElse(null);
    }

}

