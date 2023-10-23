package book.example;

public class Paragraph implements Element{

    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    public void print() {
        System.out.println("Paragraph: " + text);
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
