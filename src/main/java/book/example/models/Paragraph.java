package book.example.models;

import book.example.services.AlignStrategy;
import jakarta.persistence.*;
import lombok.Getter;
@Entity
public class Paragraph implements Element,Visitee {

    @Getter
    private String text;
    @Transient
    private AlignStrategy alignment;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sub_chapter_id")
    private SubChapter subChapter;

    public Paragraph(String text) {
        this.text = text;
    }

    public Paragraph() {

    }

    public void print() {
        System.out.println("Paragraph: " + text);
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
    public void setAlignStrategy(AlignStrategy alignment) {
        this.alignment = alignment;
    }

    public void render(Paragraph paragraph, Context context) {
        alignment.render(paragraph, context);

    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visitParagraph(this);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
