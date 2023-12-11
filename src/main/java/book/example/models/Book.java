package book.example.models;

import lombok.Getter;

import java.util.ArrayList;

public class Book extends Section implements Visitee {
    private static String titlu;
    @Getter
    private long id;
    private TableOfContents tableOfContents;

    @Getter
    private ArrayList<Chapter> chapters;
    @Getter
    private ArrayList<Author> authors;

    public Book(String titlu)
    {
        super(titlu);
        this.titlu=titlu;
//        this.id=id;
        chapters = new ArrayList<>();
        authors = new ArrayList<>();

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
}
