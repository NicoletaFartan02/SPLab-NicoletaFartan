package book.example.models;

import book.example.models.Element;
import jakarta.persistence.*;

@Entity
public class Table implements Element {

    private String title;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sub_chapter_id")
    private SubChapter subChapter;

    public Table(String title) {
        this.title = title;
    }

    public Table() {

    }

    public String getTitle() {
        return title;
    }
    public void print() {
        System.out.println("Table with Title: " + title);
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

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
