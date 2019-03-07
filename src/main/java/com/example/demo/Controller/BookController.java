package com.example.demo.Controller;

import com.example.demo.Command.CreateBookCommand;
import com.example.demo.Command.UpdateBookCommand;
import com.example.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {

    private final
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PutMapping("/add")
    public ResponseEntity addBook(@RequestBody CreateBookCommand createBookCommand) {
        bookService.addBook(createBookCommand);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/getList")
    public ResponseEntity getAllBooks() {
        bookService.getAllBooks();
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getBookById(@PathVariable(value = "id") Long id) {
        bookService.getBookById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity getBookByTitle(@PathVariable(value = "title") String title) {
        bookService.getBookByTitle(title);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateBook(@RequestBody UpdateBookCommand updateBookCommand) {
        bookService.updateBook(updateBookCommand);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable(value = "id") Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}