package com.example.Goodreads.repository;
import java.util.ArrayList;

import com.example.Goodreads.model.Book;



public interface BookRepository {
    public  ArrayList<Book> getBooks();

    public  Book getBookById(int bookId);

    public  Book addBook(Book book);

    public  Book updateBook(int bookId,Book book);

     public void DeleteBook(int bookId);
}
