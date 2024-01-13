package book.example.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Author {

    @Getter
    private String name;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
//    @OneToMany(mappedBy = "author")
//    private List<Book> books = new ArrayList<>();

    public Author(String name) {
        this.name = name;
    }

    public Author() {}

    public void print() {
        System.out.println("Author: " + name);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
