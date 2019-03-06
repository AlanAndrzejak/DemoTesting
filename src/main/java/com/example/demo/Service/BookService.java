package com.example.demo.Service;

import com.example.demo.Command.CreateBookCommand;
import com.example.demo.Command.UpdateBookCommand;
import com.example.demo.Model.Book;

import java.util.List;

public interface BookService {

    void addBook(CreateBookCommand createBookCommand);

    List<Book> getAllBooks();

    Book getBookById(Long id);

    void updateBook(UpdateBookCommand updateBookCommand);

    void deleteBook(Long id);

}
