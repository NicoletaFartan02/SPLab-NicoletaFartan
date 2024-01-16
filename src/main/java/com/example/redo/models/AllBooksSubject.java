package com.example.redo.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AllBooksSubject implements Subject{

    private List<Observer> observers = new ArrayList<>();


    public void attach(Observer observer) {
        observers.add(observer);
    }


    public void detach(Observer observer) {
        observers.remove(observer);
    }


    public void notifyObservers(Book book) {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }

    public void add(Book book) {
        notifyObservers(book);
    }
}
