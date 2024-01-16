package com.example.redo.models;

public class RenderContentVisitor implements Visitor{


    @Override
    public void visitParagraph(Paragraph paragraph) {


    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {


    }

    @Override
    public void visitImage(Image image) {


    }

    @Override
    public void visitTable(Table table) {


    }

    @Override
    public void visitSection(Section section) {
//        for (Element element : section.getElements()) {
//            element.accept(this);
//        }
    }

    @Override
    public void visitBook(Book book) {
        System.out.println("Book: " + book.getBookTitle());
        for (Author author : book.getAuthors()) {
            author.print();
        }

        for (Section section : book.getSections()) {
            section.accept(this);
        }
    }

    @Override
    public void visitTableOfContents(TableOfContents toc) {

    }
}
