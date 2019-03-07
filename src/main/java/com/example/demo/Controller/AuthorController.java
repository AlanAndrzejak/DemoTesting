package com.example.demo.Controller;

import com.example.demo.Command.CreateAuthorCommand;
import com.example.demo.Command.UpdateAuthorCommand;
import com.example.demo.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final
    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        Assert.notNull(authorService, "AuthorService can not be a null");
        this.authorService = authorService;
    }

    @PutMapping("/add")
    public ResponseEntity addAuthor(@RequestBody CreateAuthorCommand createAuthorCommand) {
        authorService.addAuthor(createAuthorCommand);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/getList")
    public ResponseEntity getAllAuthors() {
        authorService.getAllAuthors();
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getAuthorById(@PathVariable(value = "id") Long id) {
        authorService.getAuthorById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateAuthor(@RequestBody UpdateAuthorCommand updateAuthorCommand) {
        authorService.updateAuthor(updateAuthorCommand);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteAuthor(@PathVariable(value = "id") Long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}