package book.example.models;

import book.example.models.Book;
import book.example.models.Element;
import lombok.Getter;

import java.util.ArrayList;

public class Section implements Element,Visitee {

    @Getter
    private  String title;
    private ArrayList<Element> elements;


    public Section(String title){
        this.title = title;
        elements = new ArrayList<>();
    }

    @Override
    public void print() {

        if (!title.equals(Book.getBookTitle())) {
            System.out.println(title);
        }

        //System.out.println(title);
        for (Element element : elements) {
            element.print();
        }
    }

    @Override
    public void add(Element element) {
        if (elements == null) {
            elements = new ArrayList<>();
        }
        elements.add(element);
    }

    @Override
    public void remove(Element element) {
        elements.remove(element);
    }

    @Override
    public int get(Element element) {
        return elements.indexOf(element);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSection(this);
    }

    public Element[] getElements() {
        return elements.toArray(new Element[0]);
    }
}
