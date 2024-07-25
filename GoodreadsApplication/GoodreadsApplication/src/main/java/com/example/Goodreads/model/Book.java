package com.example.Goodreads.model;

import jakarta.persistence.Column;

//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "imageurl")
    private String ImageUrl;

    public Book() {

    }

    public Book(int id,String name,String ImageUrl){
        this.id=id;
        this.name=name;
        this.ImageUrl=ImageUrl;        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setBookname(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
