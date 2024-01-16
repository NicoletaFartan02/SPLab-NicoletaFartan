package com.example.redo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.awt.*;
import java.util.concurrent.TimeUnit;
@Entity
public class Image extends BaseElement implements Visitee {
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String imageName;
    @Getter
    private String url;


    public Image() {}

    public Image(String imageName) {
        this.imageName = imageName;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.println("Image with name: " + imageName);
    }

    @Override
    public void add(Element element) {}

    @Override
    public void remove(Element element) {}

    @Override
    public int get(Element element) {
        return 0;
    }
    public String url() {
        return null;
    }

    public Dimension dim() {
        return null;
    }

    public Picture.PictureContent content() {
        return null;
    }

    public void accept(Visitor visitor) {
        visitor.visitImage(this);
    }

}
