package com.anhtlnse170476.lab3;

public class Fruit {
    private String title, description, imageUrl;

    public Fruit() {}

    public Fruit(String title, String description, String imageUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
