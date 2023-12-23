package book.example.models;

import book.example.models.Image;
import book.example.models.Paragraph;
import book.example.models.Table;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
@Entity
public class SubChapter {



    @Getter
    private String name;
    @OneToMany(mappedBy = "subChapter", cascade = CascadeType.ALL)
    private ArrayList<Paragraph> paragraphs;
    @OneToMany(mappedBy = "subChapter", cascade = CascadeType.ALL)
    private ArrayList<Table> tables;
    @OneToMany(mappedBy = "subChapter", cascade = CascadeType.ALL)
    private ArrayList<Image> images;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    public SubChapter(String name) {
        this.name = name;
        paragraphs = new ArrayList<>();
        tables = new ArrayList<>();
        images = new ArrayList<>();
    }

    public SubChapter() {

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
