package com.example.redo.models;

import com.example.redo.models.Element;
import com.example.redo.models.Image;
import com.example.redo.models.Picture;
import jakarta.persistence.*;

import java.awt.*;
@Entity
public class ImageProxy extends BaseElement implements Visitee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private Dimension dim;
    @Transient
    private Image realImage = null;
    public ImageProxy(String url) {
        this.url = url;

    }

    public ImageProxy() {}

    public String url() {
        return url;
    }


    public Dimension dim() {
        return dim;
    }


    public Picture.PictureContent content() {
        return null;
    }


    public Image loadImage() {
        if (realImage == null) {
            realImage = new Image( url);
        }
        return realImage;
    }

    public void print() {
        loadImage();
        if (realImage != null) {
            realImage.print();
        } else {
            System.out.println("Proxy Image: " + url);
        }
    }

    public void add(Element element) {

    }

    public void remove(Element element) {

    }

    public int get(Element element) {
        return 0;
    }

    public void accept(Visitor visitor) {
        visitor.visitImageProxy(this);
    }
}
