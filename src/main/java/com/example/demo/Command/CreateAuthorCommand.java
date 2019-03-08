package com.example.demo.Command;

import com.example.demo.Model.Book;

import java.util.Set;

public class CreateAuthorCommand {

    private String name;

    private String address;

    private Set<Book> bookSet;

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

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookList(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}