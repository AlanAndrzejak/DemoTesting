package com.example.demo.Controller;

import com.example.demo.Command.CreateAuthorCommand;
import com.example.demo.Command.UpdateAuthorCommand;
import com.example.demo.Model.Author;
import com.example.demo.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final
    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        Assert.notNull(authorService,"AuthorService can not be a null");
        this.authorService = authorService;
    }

    @PutMapping("/add")
    public @ResponseBody void addAuthor(CreateAuthorCommand createAuthorCommand){
        authorService.addAuthor(createAuthorCommand);
    }

    @GetMapping("/getList")
    public @ResponseBody List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }
    @GetMapping("/{id}")
    public @ResponseBody Author getAuthorById(@PathVariable(value="id")Long id){
        return authorService.getAuthorById(id);
    }

    @PutMapping("/update")
    public @ResponseBody void updateAuthor(UpdateAuthorCommand updateAuthorCommand){
        authorService.updateAuthor(updateAuthorCommand);
    }

    @DeleteMapping("/delete")
    public @ResponseBody void deleteAuthor(@PathVariable(value="id")Long id){
        authorService.deleteAuthor(id);
    }
}