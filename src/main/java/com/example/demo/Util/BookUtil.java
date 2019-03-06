package com.example.demo.Util;

import com.example.demo.Command.CreateBookCommand;
import com.example.demo.Command.UpdateBookCommand;
import com.example.demo.Dao.BookDao;
import com.example.demo.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookUtil {

    private final
    BookDao bookDao;

    @Autowired
    public BookUtil(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public Book rewrite(Book book, UpdateBookCommand updateBookCommand) {
        book.setCategory(updateBookCommand.getCategory());
        book.setTitle(updateBookCommand.getTitle());
        return book;
    }

    public Book createBookCommandToBook(CreateBookCommand createBookCommand) {
        Book book = new Book();
        book.setCategory(createBookCommand.getCategory());
        book.setTitle(createBookCommand.getTitle());
        return book;
    }

    private Book bookIdToBook(Long BookId) {
        Book Book = bookDao.getBookById(BookId);
        if (Book == null) {
            throw new RuntimeException("Can not map " + BookId + " to Book");
        }
        return Book;
    }

}