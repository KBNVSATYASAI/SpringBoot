package com.example.Goodreads.model;

public class Book {
    private int id;
    private String Name;
    private String ImageUrl;

    public Book(int id,String Name,String ImageUrl){
        this.id=id;
        this.Name=Name;
        this.ImageUrl=ImageUrl;        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setBookName(String Name) {
        Name = Name;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
