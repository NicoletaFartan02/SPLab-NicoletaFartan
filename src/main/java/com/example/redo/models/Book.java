package com.example.redo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
//@Inheritance
public class Book extends Section implements Visitee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @OneToMany
    private List<Section> sections;

    @ManyToMany
    private List<Author> authors;
    public Book(String name, List<Section> sections, List<Author> authors) {
        this.name = name;
        this.sections = sections;
        this.authors = authors;
    }
    public Book() {}

    public Book(String name) {

        this.name = name;
        this.authors = new ArrayList<>();
        this.sections = new ArrayList<>();
    }


    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        if (element instanceof Section) {
            addSection((Section) element);
        } else if (element instanceof Paragraph) {
            addParagraph((Paragraph) element);}
        else {
            throw new IllegalArgumentException("Unsupported element type");
        }
    }
    private void addParagraph(Paragraph paragraph) {
        Section defaultSection = new Section("");
        defaultSection.add(paragraph);
        sections.add(defaultSection);
    }

    private void addSection(Section section) {
        sections.add(section);
    }


    public void print() {
        System.out.println("Book: " + name);

        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }

        for (Section section : sections) {
            section.print();
        }
    }
    public void setTitle(String title) {
        this.name = title;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getBookTitle() {
        return name;
    }

    public void accept(Visitor visitor) {
        visitor.visitBook(this);
    }
}
