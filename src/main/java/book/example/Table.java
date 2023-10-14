package book.example;

public class Table {

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
}
