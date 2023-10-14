package book.example;

import java.util.ArrayList;

public class Chapter {

    private String name;
    private ArrayList<SubChapter> subChapters;

    public Chapter(String name) {
        this.name = name;
        subChapters = new ArrayList<>();
    }
    public int addSubChapter(SubChapter subChapter) {
        subChapters.add(subChapter);
        return subChapters.size()-1;
    }

    public ArrayList<SubChapter> getSubChapters() {
        return subChapters;
    }
    public String getName() {
        return name;
    }
    public void print() {
        System.out.println("Chapter: " + name);

        //System.out.println("SubChapters:");
        for (SubChapter subChapter : subChapters) {
            subChapter.print();
        }
    }
}
