package book.example;

import book.example.models.*;
import book.example.services.AlignCenter;
import book.example.services.AlignLeft;
import book.example.services.AlignRight;

public class Main {

    public static void main(String args[]) throws Exception {

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


//        Book noapteBuna = new Book("Noapte buna, copii!");
//        Author rpGheo = new Author("Radu Pavel Gheo");
//        noapteBuna.addAuthor(rpGheo);
//        Section cap1 = new Section("Capitolul 1");
//        Section cap11 = new Section("Capitolul 1.1");
//        Section cap111 = new Section("Capitolul 1.1.1");
//        Section cap1111 = new Section("Subchapter 1.1.1.1");
//        noapteBuna.addContent(new Paragraph("Multumesc celor care ..."));
//        noapteBuna.addContent(cap1);
//        cap1.add(new Paragraph("Moto capitol"));
//        cap1.add(cap11);
//        cap11.add(new Paragraph("Text from subchapter 1.1"));
//        cap11.add(cap111);
//        cap111.add(new Paragraph("Text from subchapter 1.1.1"));
//        cap111.add(cap1111);
//        cap1111.add(new Image("Image subchapter 1.1.1.1"));
//        noapteBuna.print();


//        long startTime = System.currentTimeMillis();
//        Image img1 = new Image("Pamela Anderson");
//        Image img2 = new Image("Kim Kardashian");
//        Image img3 = new Image("Kirby Griffin");
//        Section playboyS1 = new Section("Front Cover");
//        playboyS1.add(img1);
//        Section playboyS2 = new Section("Summer Girls");
//        playboyS2.add(img2);
//        playboyS2.add(img3);
//        Book playboy = new Book("Playboy");
//        playboy.addContent(playboyS1);
//        playboy.addContent(playboyS2);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Creation of the content took " + (endTime -
//                startTime) + " milliseconds");
//        startTime = System.currentTimeMillis();
//        playboyS1.print();
//        endTime = System.currentTimeMillis();
//        System.out.println("Printing of the section 1 took " + (endTime -
//                startTime) + " milliseconds");
//        startTime = System.currentTimeMillis();
//        playboyS1.print();
//        endTime = System.currentTimeMillis();
//        System.out.println("Printing again the section 1 took " + (endTime -
//                startTime) + " milliseconds");
//    }

//        long startTime = System.currentTimeMillis();
//        ImageProxy img1 = new ImageProxy("Pamela Anderson");
//        ImageProxy img2 = new ImageProxy("Kim Kardashian");
//        ImageProxy img3 = new ImageProxy("Kirby Griffin");
//        Section playboyS1 = new Section("Front Cover");
//        playboyS1.add(img1);
//        Section playboyS2 = new Section("Summer Girls");
//        playboyS2.add(img2);
//        playboyS2.add(img3);
//        Book playboy = new Book("Playboy");
//        playboy.addContent(playboyS1);
//        playboy.addContent(playboyS2);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Creation of the content took " + (endTime -
//                startTime) + " milliseconds");
//        startTime = System.currentTimeMillis();
//        playboyS1.print();
//        endTime = System.currentTimeMillis();
//        System.out.println("Printing of the section 1 took " + (endTime -
//                startTime) + " milliseconds");
//        startTime = System.currentTimeMillis();
//        playboyS1.print();
//        endTime = System.currentTimeMillis();
//        System.out.println("Printing again the section 1 took " + (endTime -
//                startTime) + " milliseconds");
//    }


//        Section cap1 = new Section("Capitolul 1");
//        Paragraph p1 = new Paragraph("This is a long text that needs to be center-aligned in lines of 60 characters. The text will be broken into multiple lines, and each line will be center-aligned. This is an example of how to achieve this in Java.");
//        cap1.add(p1);
//        Paragraph p2 = new Paragraph("This is a long text that needs to be right-aligned in lines of 60 characters. The text will be broken into multiple lines, and each line will be right-aligned. This is an example of how to achieve this in Java.");
//        cap1.add(p2);
//        Paragraph p3 = new Paragraph("This is a long text that needs to be left-aligned in lines of 60 characters. The text will be broken into multiple lines, and each line will be left-aligned. This is an example of how to achieve this in Java.");
//        cap1.add(p3);
//        Paragraph p4 = new Paragraph("Paragraph 4");
//        cap1.add(p4);
//        System.out.println("Printing without Alignment");
//        System.out.println();
//        cap1.print();
//        Context context = new Context(60);
//        p1.setAlignStrategy(new AlignCenter());
//        p2.setAlignStrategy(new AlignRight());
//        p3.setAlignStrategy(new AlignLeft());
//        System.out.println();
//        System.out.println("Printing with Alignment");
//        p1.render(p1,context);
//        p2.render(p2,context);
//        p3.render(p3,context);
        Book book = new Book("Design Patterns");
        new RenderContentVisitor().visitBook(book);
//        book.accept(new RenderContentVisitor());



    }
}


