package book.example.models;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

public class RenderContentVisitor implements Visitor{


    @Override
    public void visitParagraph(Paragraph paragraph) {

    }

    @Override
    public void visitSection(Section section) {


    }

    @Override
    public void visitImage(Image image) {

    }

    @Override
    public void visitTableOfContents(TableOfContents table) {

    }

    @Override
    public void visitBook(Book book) {
        System.out.println("Rendering Book: " + book.getBookTitle());
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {

    }
}
