package com.example.redo.models;

import jakarta.persistence.*;
import lombok.Getter;
@Entity
@Getter
public class Table extends BaseElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    public Table(String title) {
        this.title = title;
    }

    public Table() {}

    public void print() {
        System.out.println("Table with Title: " + title);
    }

    @Override
    public void add(Element element) {}

    @Override
    public void remove(Element element) {}

    @Override
    public int get(Element element) {
        return 0;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTable(this);
    }


}
