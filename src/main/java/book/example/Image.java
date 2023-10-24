package book.example;

import lombok.Getter;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Image implements Element,Picture{

    @Getter
    private String imageName;
    private String url;
    private PictureContent content;

    public Image(String imageName)
    {
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
    public String url() {
        return null;
    }

    @Override
    public Dimension dim() {
        return null;
    }

    @Override
    public PictureContent content() {
        return null;
    }
}
