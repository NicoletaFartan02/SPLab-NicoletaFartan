package com.example.redo.models;

import jakarta.persistence.*;
import lombok.Getter;
@Entity
@Getter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Author(String name) {
        this.name = name;
    }

    public Author() {}

    public void print() {
        System.out.println("Author: " + name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
