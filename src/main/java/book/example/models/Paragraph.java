package book.example.models;

import book.example.services.AlignStrategy;
import lombok.Getter;

public class Paragraph implements Element,Visitee {

    @Getter
    private String text;
    private AlignStrategy alignment;

    public Paragraph(String text) {
        this.text = text;
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
}
