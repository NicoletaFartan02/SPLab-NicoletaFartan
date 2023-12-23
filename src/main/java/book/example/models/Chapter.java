package book.example.models;

import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
public class Chapter {

    private String name;
    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL)
    private ArrayList<SubChapter> subChapters;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Chapter(String name) {
        this.name = name;
        subChapters = new ArrayList<>();
    }

    public Chapter() {

    }

    public int addSubChapter(SubChapter subChapter) {
        subChapters.add(subChapter);
        return subChapters.size()-1;
    }

    public ArrayList<SubChapter> getSubChapters() {
        return subChapters;
    }
    public String getName() {
        return name;
    }
    public void print() {
        System.out.println("Chapter: " + name);

        //System.out.println("SubChapters:");
        for (SubChapter subChapter : subChapters) {
            subChapter.print();
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
