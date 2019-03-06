package com.example.demo.Command;

public class UpdateBookCommand {

    private Long id;

    private String title;

    private String category;

    public UpdateBookCommand() {
    }

    public UpdateBookCommand(Long id, String title, String category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }

    public Long getId() {
        return id;
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