package com.example.demo.Dao.Impl;

import com.example.demo.Dao.AuthorDao;
import com.example.demo.Model.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        return entityManager.createQuery("select a from Author a").getResultList();
    }

    @Override
    public Author getAuthorById(Long id) {
        String select = "Select a from Author a where a.id =:id";
        Query query = entityManager.createQuery(select);
        query.setParameter("id", id);
        query.setMaxResults(1);
        List<Author> list = query.getResultList();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }


    @Override
    public Author getAuthorByName(String name) {
        String select = "Select a from Author a where a.name =:name";
        Query query = entityManager.createQuery(select);
        query.setParameter("name", name);
        query.setMaxResults(1);
        List<Author> list = query.getResultList();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public void updateAuthor(Author author) {
        entityManager.merge(author);
    }

    @Override
    public void deleteAuthor(Author author) {
        entityManager.remove(author);

    }
}