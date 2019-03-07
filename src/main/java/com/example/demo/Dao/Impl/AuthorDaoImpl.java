package com.example.demo.Dao.Impl;

import com.example.demo.Dao.AuthorDao;
import com.example.demo.Model.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addAuthor(Author author) {
        entityManager.persist(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return null;
    }

    @Override
    public Author getAuthorById(Long id) {
        return null;
    }

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    public void deleteAuthor(Author author) {

    }
}