package book.example;

import lombok.Getter;

import java.util.ArrayList;

public class Book extends Section {
    private static String titlu;
    private TableOfContents tableOfContents;



    @Getter
    private ArrayList<Chapter> chapters;
    @Getter
    private ArrayList<Author> authors;

    public Book(String titlu)
    {
        super(titlu);
        this.titlu=titlu;
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
}
