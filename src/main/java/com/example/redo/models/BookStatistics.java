package com.example.redo.models;

public class BookStatistics implements Visitor{

    private int imageCount = 0;
    private int tableOfContentsCount = 0;
    private int tableCount = 0;

    private int paragraphCount = 0;

    @Override
    public void visitTable(Table table) {
        tableCount++;
    }
    @Override
    public void visitImage(Image image) {
        imageCount++;
    }

    @Override
    public void visitTableOfContents(TableOfContents table) {
        tableOfContentsCount++;
    }

    @Override
    public void visitBook(Book book) {

    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
            imageCount++;
    }


    @Override
    public void visitParagraph(Paragraph paragraph) {
        paragraphCount++;
    }

    @Override
    public void visitSection(Section section) {

    }

    public void printStatistics() {
        System.out.println("Books Statistics:");
        System.out.println("*** Number of images: " + imageCount);
        System.out.println("*** Number of tables: " + tableCount);
        System.out.println("*** Number of paragraphs: " + paragraphCount);
    }
}
