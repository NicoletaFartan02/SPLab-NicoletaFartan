package book.example;

public class Main {

    public static void main(String args[]) {
//        Book discoTitanic = new Book("Disco Titanic");
//        Author author = new Author("Radu Pavel Gheo");
//
//        discoTitanic.addAuthor(author);
//        int indexChapterOne = discoTitanic.addChapter(new Chapter("Capitolul 1"));
//        Chapter chp1 = discoTitanic.getChapter(indexChapterOne);
//        int indexSubChapterOneOne = chp1.addSubChapter(new SubChapter("Subcapitolul 1.1"));
//        SubChapter scOneOne = chp1.getSubChapters().get(indexSubChapterOneOne);
//
//
//        scOneOne.addParagraph(new Paragraph("Paragraph 1"));
//        scOneOne.addParagraph(new Paragraph("Paragraph 2"));
//        scOneOne.addParagraph(new Paragraph("Paragraph 3"));
//        scOneOne.addImage(new Image("Image 1"));
//        scOneOne.addParagraph(new Paragraph("Paragraph 4"));
//        scOneOne.addTable(new Table("Table 1"));
//        scOneOne.addParagraph(new Paragraph("Paragraph 5"));
//        scOneOne.print();


        Book noapteBuna = new Book("Noapte buna, copii!");
        Author rpGheo = new Author("Radu Pavel Gheo");
        noapteBuna.addAuthor(rpGheo);
        Section cap1 = new Section("Capitolul 1");
        Section cap11 = new Section("Capitolul 1.1");
        Section cap111 = new Section("Capitolul 1.1.1");
        Section cap1111 = new Section("Subchapter 1.1.1.1");
        noapteBuna.addContent(new Paragraph("Multumesc celor care ..."));
        noapteBuna.addContent(cap1);
        cap1.add(new Paragraph("Moto capitol"));
        cap1.add(cap11);
        cap11.add(new Paragraph("Text from subchapter 1.1"));
        cap11.add(cap111);
        cap111.add(new Paragraph("Text from subchapter 1.1.1"));
        cap111.add(cap1111);
        cap1111.add(new Image("Image subchapter 1.1.1.1"));
        noapteBuna.print();

    }
}
