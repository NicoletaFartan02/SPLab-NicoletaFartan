package book.example;

public class Table implements Element{

    private String title;

    public Table(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void print() {
        System.out.println("Table with Title: " + title);
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
}
