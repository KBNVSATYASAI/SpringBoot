package com.example.GoodreadsApplication;

public class Book {
    private int id;
    private String BookName;
    private String ImageUrl;

    public Book(int id,String BookName,String ImageUrl){
        this.id=id;
        this.BookName=BookName;
        this.ImageUrl=ImageUrl;        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
