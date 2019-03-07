package com.example.demo.Util;

import com.example.demo.Command.CreateAuthorCommand;
import com.example.demo.Command.UpdateAuthorCommand;
import com.example.demo.Dao.AuthorDao;
import com.example.demo.Model.Author;
import com.example.demo.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

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
        this.removeExistBook(createAuthorCommand);
        author.setBooks(createAuthorCommand.getBookList());
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
        Set<Book> books = createAuthorCommand.getBookList();
        books.removeIf(book -> bookUtil.bookTitleToBook(book.getTitle()) != null);
    }

}