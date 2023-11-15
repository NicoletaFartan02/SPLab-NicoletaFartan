package book.example.models;

import book.example.models.Element;

public class TableOfContents implements Element, Visitee {
    public void print() {
        System.out.println("Table of Contents:");
    }
    @Override
    public void add(Element element) {

    }

    @Override
    public void remove(Element element) {

    }

    @Override
    public int get(Element element) {

        return -1;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTableOfContents(this);
    }
}

