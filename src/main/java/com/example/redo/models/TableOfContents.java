package com.example.redo.models;
import java.util.ArrayList;
import java.util.List;

public class TableOfContents implements Element, Visitee {
    private List<String> entries;

    public TableOfContents() {
        this.entries = new ArrayList<>();
    }

    @Override
    public void print() {
        System.out.println("Table of Contents:");
        for (String entry : entries) {
            System.out.println("- " + entry);
        }
    }

    @Override
    public void add(Element element) {}

    @Override
    public void remove(Element element) {}

    public void addEntry(String entry, int page) {
        entries.add(entry + " .............................. " + page);
    }

    public void removeEntry(String entry) {
        entries.remove(entry);
    }

    @Override
    public int get(Element element) {
        return 0;
    }

    public void accept(Visitor visitor) {
        visitor.visitTableOfContents(this);
    }

    public List<String> getEntries() {
        return new ArrayList<>(entries);
    }
}
