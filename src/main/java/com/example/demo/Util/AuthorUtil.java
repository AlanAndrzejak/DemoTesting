package com.example.demo.Util;

import com.example.demo.Command.CreateAuthorCommand;
import com.example.demo.Command.UpdateAuthorCommand;
import com.example.demo.Dao.AuthorDao;
import com.example.demo.Model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorUtil {

    private final
    AuthorDao authorDao;

    @Autowired
    public AuthorUtil(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }


    public Author createAuthorCommandToAuthor(CreateAuthorCommand createAuthorCommand){
        Author author = new Author();
        author.setAddress(createAuthorCommand.getAddress());
        author.setName(createAuthorCommand.getName());
        return author;
    }

    private Author authorIdToAuthor(Long id) {
        Author title = authorDao.getAuthorById(id);
        if (title == null) {
            throw new RuntimeException("Can not map " + id + " to Title");
        }
        return title;
    }

    public Author rewrite(Author author, UpdateAuthorCommand updateAuthorCommand){
        author.setAddress(updateAuthorCommand.getAddress());
        author.setName(updateAuthorCommand.getName());
        return author;
    }

}