package com.example.demo.Dao.Impl;

import com.example.demo.Dao.BookDao;
import com.example.demo.Model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return entityManager.createQuery("select b from Book b").getResultList();
    }

    @Override
    public Book getBookById(Long id) {
        String select = "select b from Book b where b.id = :id";
        Query query = entityManager.createQuery(select);
        query.setParameter("id", id);
        query.setMaxResults(1);
        List<Book> list = query.getResultList();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public Book getBookByTitle(String title) {
        String select = "select b from Book b where b.title = :title";
        Query query = entityManager.createQuery(select);
        query.setParameter("title", title);
        query.setMaxResults(1);
        List<Book> list = query.getResultList();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public void updateBook(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void deleteBook(Book book) {
        entityManager.remove(book);
    }
}