package com.example.demo.Service.Impl;

import com.example.demo.Command.CreateAuthorCommand;
import com.example.demo.Command.UpdateAuthorCommand;
import com.example.demo.Dao.AuthorDao;
import com.example.demo.Model.Author;
import com.example.demo.Service.AuthorService;
import com.example.demo.Util.AuthorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final
    AuthorDao authorDaoImpl;

    private final
    AuthorUtil authorUtil;

    @Autowired
    public AuthorServiceImpl(AuthorDao authorDaoImpl, AuthorUtil authorUtil) {
        Assert.notNull(authorDaoImpl, "AuthorDao can not be a null");
        Assert.notNull(authorUtil, "AuthorUtil can not be a null");
        this.authorDaoImpl = authorDaoImpl;
        this.authorUtil = authorUtil;
    }

    @Override
    @Transactional
    public void addAuthor(CreateAuthorCommand createAuthorCommand) {
        Author author = authorUtil.createAuthorCommandToAuthor(createAuthorCommand);
        authorDaoImpl.addAuthor(author);
    }

    @Override
    @Transactional
    public List<Author> getAllAuthors() {
        return authorDaoImpl.getAllAuthors();
    }

    @Override
    @Transactional
    public Author getAuthorById(Long id) {
        return authorDaoImpl.getAuthorById(id);
    }

    @Override
    @Transactional
    public void updateAuthor(UpdateAuthorCommand updateAuthorCommand) {
        if (updateAuthorCommand.getId() == null) {
            throw new RuntimeException("Author ID can not be a null");
        }
        Author author = authorDaoImpl.getAuthorById(updateAuthorCommand.getId());
        authorUtil.rewrite(author, updateAuthorCommand);
        authorDaoImpl.updateAuthor(author);
    }

    @Override
    @Transactional
    public void deleteAuthor(Long id) {
        Author author = this.getAuthorById(id);
        authorDaoImpl.deleteAuthor(author);
    }
}