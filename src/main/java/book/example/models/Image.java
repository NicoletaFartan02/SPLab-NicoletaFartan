package book.example.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.awt.*;
import java.util.concurrent.TimeUnit;
@Entity
public class Image implements Element, Picture, Visitee {

    @Getter
    private String imageName;
    private String url;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sub_chapter_id")
    private SubChapter subChapter;

    public Image(String imageName)
    {
        this.imageName = imageName;
        try {

            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Image() {

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

    @Override
    public void accept(Visitor visitor) {
        visitor.visitImage(this);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
