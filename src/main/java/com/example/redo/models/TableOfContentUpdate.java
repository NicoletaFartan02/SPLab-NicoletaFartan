package com.example.redo.models;

public class TableOfContentUpdate implements Visitor{
    private int currentPage = 1;
    private TableOfContents toc;

    public TableOfContentUpdate() {
        this.toc = new TableOfContents();
    }

    public TableOfContents getToC() {
        return toc;
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        toc.addEntry("Chapter " + currentPage, currentPage);
        currentPage++;
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        toc.addEntry("Chapter " + currentPage, currentPage);
        currentPage++;
    }

    @Override
    public void visitImage(Image image) {
        toc.addEntry("Chapter " + currentPage, currentPage);
        currentPage++;
    }

    @Override
    public void visitTable(Table table) {
        toc.addEntry("Chapter " + currentPage, currentPage);
        currentPage++;
    }

    @Override
    public void visitSection(Section section) {
        for (Element element : section.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visitBook(Book book) {
        for (Section section : book.getSections()) {
            section.accept(this);
        }
    }

    @Override
    public void visitTableOfContents(TableOfContents toc) {

    }
}
