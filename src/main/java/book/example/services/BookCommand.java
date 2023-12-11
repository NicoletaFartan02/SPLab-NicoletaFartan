package book.example.services;

public interface BookCommand<T>{
    T execute();
}
