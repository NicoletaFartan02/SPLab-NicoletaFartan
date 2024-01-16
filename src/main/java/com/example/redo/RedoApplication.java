package com.example.redo;

import com.example.redo.models.Author;
import com.example.redo.models.Book;
import com.example.redo.models.Section;
import com.example.redo.repositories.BooksRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = "com.example.redo.models")
public class RedoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(RedoApplication.class, args);
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(RedoApplication.class, args);
        BooksRepository booksRepository1 = configurableApplicationContext.getBean(BooksRepository.class);
//        Author author = new Author("Ionascu");
//        Section cap1 =  new Section("Default chapter");
//        Section cap2 =  new Section("Default chapter2");
//        List<Section> sections = new ArrayList<>();
//        sections.add(cap1);
//        sections.add(cap2);
//
//        List<Author> authors = new ArrayList<>();
//        authors.add(author);
//        Book book = new Book("O carte");
//        booksRepository1.save(book);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/books").allowedOrigins("http://localhost:8080");
            }
        };
    }

    }


