package com.example.demo.Service.Impl;

import com.example.demo.Command.CreateBookCommand;
import com.example.demo.Command.UpdateBookCommand;
import com.example.demo.Dao.BookDao;
import com.example.demo.Model.Book;
import com.example.demo.Service.BookService;
import com.example.demo.Util.BookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final
    BookDao bookDaoImpl;

    private final
    BookUtil bookUtil;

    @Autowired
    public BookServiceImpl(BookDao bookDaoImpl, BookUtil bookUtil) {
        Assert.notNull(bookDaoImpl, "BookDao can not be a null");
        Assert.notNull(bookUtil, "BookUtil can not be a null");
        this.bookDaoImpl = bookDaoImpl;
        this.bookUtil = bookUtil;
    }

    @Override
    @Transactional
    public void addBook(CreateBookCommand createBookCommand) {
        Book book = bookUtil.createBookCommandToBook(createBookCommand);
        bookDaoImpl.addBook(book);
    }

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookDaoImpl.getAllBooks();
    }

    @Override
    @Transactional
    public Book getBookById(Long id) {
        return bookDaoImpl.getBookById(id);
    }

    @Override
    @Transactional
    public Book getBookByTitle(String title) {
        return bookDaoImpl.getBookByTitle(title);
    }

    @Override
    @Transactional
    public void updateBook(UpdateBookCommand updateBookCommand) {
        if (updateBookCommand.getId() == null) {
            throw new IllegalArgumentException("Book id can not be null");
        }
        Book book = bookDaoImpl.getBookById(updateBookCommand.getId());
        bookUtil.rewrite(book, updateBookCommand);
        bookDaoImpl.updateBook(book);
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        Book book = this.getBookById(id);
        bookDaoImpl.updateBook(book);
    }
}