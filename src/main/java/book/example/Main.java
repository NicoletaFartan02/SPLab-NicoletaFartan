package book.example;

public class Main {

    public static void main(String args[])
    {
        Book discoTitanic = new Book("Disco Titanic");
        Author author = new Author("Radu Pavel Gheo");

        discoTitanic.addAuthor(author);
        int indexChapterOne = discoTitanic.addChapter(new Chapter("Capitolul 1"));
        Chapter chp1 = discoTitanic.getChapter(indexChapterOne);
        int indexSubChapterOneOne = chp1.addSubChapter(new SubChapter("Subcapitolul 1.1"));
        SubChapter scOneOne = chp1.getSubChapters().get(indexSubChapterOneOne);


        scOneOne.addParagraph(new Paragraph("Paragraph 1"));
        scOneOne.addParagraph(new Paragraph("Paragraph 2"));
        scOneOne.addParagraph(new Paragraph("Paragraph 3"));
        scOneOne.addImage(new Image("Image 1"));
        scOneOne.addParagraph(new Paragraph("Paragraph 4"));
        scOneOne.addTable(new Table("Table 1"));
        scOneOne.addParagraph(new Paragraph("Paragraph 5"));
        scOneOne.print();
    }
}
