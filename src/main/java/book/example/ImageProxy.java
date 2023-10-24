package book.example;

import java.awt.*;

public class ImageProxy implements Element,Picture{

    private String url;
    private Dimension dim;
    private Image realImage = null;
    public ImageProxy(String url) {
        this.url = url;

    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public Dimension dim() {
        return dim;
    }

    @Override
    public PictureContent content() {
        return null;
    }


    public Image loadImage() {
        if (realImage == null) {
            realImage = new Image( url);
        }
        return realImage;
    }

    @Override
    public void print() {
        loadImage();
        if (realImage != null) {
            realImage.print();
        } else {
            System.out.println("Proxy Image: " + url);
        }
    }

    @Override
    public void add(Element element) {

    }

    @Override
    public void remove(Element element) {

    }

    @Override
    public int get(Element element) {
        return 0;
    }
}
