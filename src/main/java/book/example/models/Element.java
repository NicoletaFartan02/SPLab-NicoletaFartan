package book.example.models;

public interface Element {
    void print();
    void add(Element element);
    void remove(Element element);
    int get(Element element);

    void accept(Visitor visitor);
}
