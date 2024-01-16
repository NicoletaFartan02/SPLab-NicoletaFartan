package com.example.redo.services;

public interface CommandExecutor {
    abstract Request executeCommand(Command command, BookService bookService);
}
