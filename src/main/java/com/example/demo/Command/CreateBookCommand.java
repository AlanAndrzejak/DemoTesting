package com.example.demo.Command;

public class CreateBookCommand {

    private String title;

    private String category;

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
}