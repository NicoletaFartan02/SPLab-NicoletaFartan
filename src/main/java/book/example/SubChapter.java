package book.example;

import lombok.Getter;

import java.util.ArrayList;

public class SubChapter {



    @Getter
    private String name;
    private ArrayList<Paragraph> paragraphs;
    private ArrayList<Table> tables;
    private ArrayList<Image> images;

    public SubChapter(String name) {
        this.name = name;
        paragraphs = new ArrayList<>();
        tables = new ArrayList<>();
        images = new ArrayList<>();
    }
    public void addParagraph(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public ArrayList<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void print() {
        System.out.println("SubChapter: " + name);

        //System.out.println("Paragraphs:");
        for (Paragraph paragraph : paragraphs) {
            paragraph.print();
        }

        //System.out.println("Images:");
        for (Image image : images) {
            image.print();
        }

       // System.out.println("Tables:");
        for (Table table : tables) {
            table.print();
        }
    }

}
