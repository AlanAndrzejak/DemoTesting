package com.example.demo.Command;

import com.example.demo.Model.Author;

import java.util.Set;

public class CreateBookCommand {

    private String title;

    private String category;

    private Set<Author> authorSet;

    public CreateBookCommand() {
    }

    public CreateBookCommand(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }
}