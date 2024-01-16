package com.example.redo.models;

import java.io.Serializable;

public interface Element extends Serializable {

    void print();
    void add(Element element);
    void remove(Element element);
    int get(Element element);

    void accept(Visitor visitor);
}
