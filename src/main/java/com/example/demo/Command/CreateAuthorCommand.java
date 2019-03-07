package com.example.demo.Command;

import com.example.demo.Model.Book;

import java.util.Set;

public class CreateAuthorCommand {

    private String name;

    private String address;

    private Set<Book> bookList;

    public CreateAuthorCommand() {
    }

    public CreateAuthorCommand(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Book> getBookList() {
        return bookList;
    }

    public void setBookList(Set<Book> bookList) {
        this.bookList = bookList;
    }
}