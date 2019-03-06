package com.example.demo.Dao;

import com.example.demo.Model.Book;

import java.util.List;

public interface BookDao {

    void addBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Long id);

    void updateBook(Book book);

    void deleteBook(Book book);

}
