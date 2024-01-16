package com.example.redo;

import com.example.redo.models.*;
import com.example.redo.services.AlignCenter;
import com.example.redo.services.AlignLeft;
import com.example.redo.services.AlignRight;

public class Main {

    public static void main(String args[]) throws Exception {

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
//
//        playboyS1.print();
//        endTime = System.currentTimeMillis();
//        System.out.println("Printing of the section 1 took " + (endTime -
//                startTime) + " milliseconds");
//        startTime = System.currentTimeMillis();
//        playboyS1.print();
//        endTime = System.currentTimeMillis();
//        System.out.println("Printing again the section 1 took " + (endTime -
//                startTime) + " milliseconds");
//


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



        Book b = new Book("The book");
        Section cap1 = new Section("Chapter 1");
        Section cap11 = new Section("Subchapter 1.1");
        Section cap2 = new Section("Chapter 2");
        cap1.add(new Paragraph("Paragraph 1"));
        cap1.add(new Paragraph("Paragraph 2"));
        cap1.add(new Paragraph("Paragraph 3"));

        cap11.add(new ImageProxy("ImageOne"));
        cap11.add(new Image("ImageTwo"));

        cap2.add(new Paragraph("Paragraph 4"));
        cap1.add(cap11);
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));
        b.addContent(cap1);
        b.addContent(cap2);
        TableOfContentUpdate tocUpdate = new TableOfContentUpdate();
        b.accept(tocUpdate);
//        tocUpdate.getToC().accept(new RenderContentVisitor());
        new RenderContentVisitor().visitBook(b);
//        Book book = new Book("Design Patterns");
//        new RenderContentVisitor().visitBook(book);

    }




}



