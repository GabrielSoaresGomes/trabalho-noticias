package com.example.trabalho_noticias;

public class News {
    private String title;
    private String description;
    private String fullDescription;
    private String category;
    private int imageResource;

    public News(String title, String description, int imageResource, String category, String fullDescription) {
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
        this.category = category;
        this.fullDescription = fullDescription;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getCategory() {
        return category;
    }

    public String getFullDescription() {
        return fullDescription;
    }
}
