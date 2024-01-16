package com.example.redo.models;

public interface Visitor {

    void visitParagraph(Paragraph paragraph);
    void visitSection(Section section);
    void visitImage(Image image);
    void visitTableOfContents(TableOfContents table);
    void visitBook(Book book);
    void visitImageProxy(ImageProxy imageProxy);
    void visitTable(Table table);
}
