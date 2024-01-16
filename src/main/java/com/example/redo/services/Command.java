package com.example.redo.services;

public interface Command <T>{

    T execute();
}
