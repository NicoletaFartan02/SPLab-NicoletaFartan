package book.example;

public interface Element {
    void print();
    void add(Element element);
    void remove(Element element);
    int get(Element element);
}
