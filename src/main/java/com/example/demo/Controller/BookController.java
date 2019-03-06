package com.example.demo.Controller;

import com.example.demo.Command.CreateBookCommand;
import com.example.demo.Command.UpdateBookCommand;
import com.example.demo.Model.Book;
import com.example.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public @ResponseBody
    void addBook(CreateBookCommand createBookCommand) {
        bookService.addBook(createBookCommand);
    }

    @GetMapping("/getList")
    public @ResponseBody
    List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Book getBookById(@PathVariable(value = "id") Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/update")
    public @ResponseBody
    void updateBook(UpdateBookCommand updateBookCommand) {
        bookService.updateBook(updateBookCommand);
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody
    void deleteBook(@PathVariable(value = "id") Long id) {
        bookService.deleteBook(id);
    }
}