package com.example.redo.models;

import com.example.redo.services.AlignStrategy;
import jakarta.persistence.*;
import lombok.Getter;
@Entity
@Getter
public class Paragraph extends BaseElement implements Visitee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private  String text;

    @Transient
    private AlignStrategy alignment;

    public Paragraph(String text) {
        this.text = text;
    }

    public Paragraph() {}

    public void print() {
        System.out.println("Paragraph: " + text);
    }

    @Override
    public void add(Element element) {}

    @Override
    public void remove(Element element) {}

    @Override
    public int get(Element element) {
        return 0;
    }

    public void setAlignStrategy(AlignStrategy alignment) {
        this.alignment = alignment;
    }

    public void render(Paragraph paragraph, Context context) {
        alignment.render(paragraph, context);

    }
    public void accept(Visitor visitor) {
        visitor.visitParagraph(this);
    }
}
