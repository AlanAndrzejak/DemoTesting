package com.example.demo.Service;

import com.example.demo.Command.CreateAuthorCommand;
import com.example.demo.Command.UpdateAuthorCommand;
import com.example.demo.Model.Author;

import java.util.List;

public interface AuthorService {

    void addAuthor(CreateAuthorCommand createAuthorCommand);

    List<Author> getAllAuthors();

    Author getAuthorById(Long id);

    void updateAuthor(UpdateAuthorCommand updateAuthorCommand);

    void deleteAuthor(Long id);

}
