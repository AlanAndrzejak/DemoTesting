package com.example.demo.Dao;

import com.example.demo.Model.Author;

import java.util.List;

public interface AuthorDao {

    void addAuthor(Author author);

    List<Author> getAllAuthors();

    Author getAuthorById(Long id);

    void updateAuthor(Author author);

    void deleteAuthor(Author author);

}
