package com.example.redo.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Section extends BaseElement implements Visitee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String title;
    @Getter
//    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL)
    @ElementCollection
    @CollectionTable(name = "section_elements", joinColumns = @JoinColumn(name = "section_id"))
    private List<Element> elements = new ArrayList<>();

    public Section(String title){
        this.title = title;
        elements = new ArrayList<>();
    }

    public Section() {}

    @Override
    public void print() {

//        if (!title.equals(Book.getBookTitle())) {
//            System.out.println(title);
//        }
//        System.out.println(title);

        System.out.println(title);
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

    public void accept(Visitor visitor) {
        visitor.visitSection(this);
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
