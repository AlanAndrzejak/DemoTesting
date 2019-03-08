package com.example.demo.Util;

import com.example.demo.Command.CreateAuthorCommand;
import com.example.demo.Command.UpdateAuthorCommand;
import com.example.demo.Dao.AuthorDao;
import com.example.demo.Model.Author;
import com.example.demo.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AuthorUtil {

    private final
    AuthorDao authorDao;

    private final
    BookUtil bookUtil;

    @Autowired
    public AuthorUtil(AuthorDao authorDao, BookUtil bookUtil) {
        this.authorDao = authorDao;
        this.bookUtil = bookUtil;
    }


    public Author createAuthorCommandToAuthor(CreateAuthorCommand createAuthorCommand) {
        Author author = new Author();
        author.setAddress(createAuthorCommand.getAddress());
        author.setName(createAuthorCommand.getName());
        author.setBooks(createAuthorCommand.getBookSet());
        return author;
    }

    private Author authorIdToAuthor(Long id) {
        Author title = authorDao.getAuthorById(id);
        if (title == null) {
            throw new RuntimeException("Can not map " + id + " to Title");
        }
        return title;
    }

    public Author rewrite(Author author, UpdateAuthorCommand updateAuthorCommand) {
        author.setAddress(updateAuthorCommand.getAddress());
        author.setName(updateAuthorCommand.getName());
        return author;
    }

    private void removeExistBook(CreateAuthorCommand createAuthorCommand) {
        Set<Book> books = createAuthorCommand.getBookSet();
        books.removeIf(book -> bookUtil.bookTitleToBook(book.getTitle()) != null);
    }

    public Set<Book> getExistBooksFromAuthor(Author author) {
        Set<Book> books = new HashSet<>();
        books = author.getBooks().stream().map(book -> bookUtil.bookTitleToBook(book.getTitle())).filter(Objects::nonNull).collect(Collectors.toSet());
        return books;
    }

}