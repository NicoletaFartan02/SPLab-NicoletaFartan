package book.example.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;

@Entity
@Inheritance
public class Book extends Section implements Visitee {
    private static String titlu;
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private TableOfContents tableOfContents;

    @Getter
    @OneToMany
    private ArrayList<Chapter> chapters;
    @Getter
    @OneToMany(mappedBy = "book")
    private ArrayList<Author> authors;

    public Book(String titlu)
    {
        super(titlu);
        this.titlu=titlu;
//        this.id=id;
        chapters = new ArrayList<>();
        authors = new ArrayList<>();

    }

    public Book() {
        super(titlu);

    }

    public static String getBookTitle() {
        return titlu;
    }

    public int addChapter(Chapter chapter) {
        chapters.add(chapter);
        return chapters.size()-1;
    }


    public void addAuthor(Author author) {
        authors.add(author);
    }

    public Chapter getChapter(int index) {
        if (index >= 0 && index < chapters.size()) {
            return chapters.get(index);
        }
        return null;
    }

    public void print() {



        System.out.println("Book: " + titlu);


        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }

        //System.out.println("Chapters:");
        for (Chapter chapter : chapters) {
            chapter.print();
        }
        super.print();
    }




    public void addContent(Element element) {
        add(element);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBook(this);
    }

    public void setId(long bookId) {
        this.id=bookId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
