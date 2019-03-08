package com.example.demo.Util;

import com.example.demo.Command.CreateBookCommand;
import com.example.demo.Command.UpdateBookCommand;
import com.example.demo.Dao.BookDao;
import com.example.demo.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

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
        book.setAuthors(createBookCommand.getAuthorSet());
        return book;
    }

    private Book bookIdToBook(Long bookId) {
        Book book = bookDao.getBookById(bookId);
        if (book == null) {
            throw new RuntimeException("Can not map " + bookId + " to Book");
        }
        return book;
    }

    public Book bookTitleToBook(String title) {
        Book book = bookDao.getBookByTitle(title);
        if (book == null) {
            Logger.getAnonymousLogger().info("Book with title " + title + " not found");
        }
        return book;
    }

}