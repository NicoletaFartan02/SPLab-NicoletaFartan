package com.example.redo.services;

import com.example.redo.models.Book;

import java.io.IOException;

public interface Observer {
    void update(Book book) throws IOException;
}
