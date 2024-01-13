package book.example.models;

import book.example.models.Element;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class TableOfContents implements Element, Visitee {
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    public TableOfContents(Long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public TableOfContents() {

    }

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

    public void setId(Long id) {
        this.id = id;
    }

}

