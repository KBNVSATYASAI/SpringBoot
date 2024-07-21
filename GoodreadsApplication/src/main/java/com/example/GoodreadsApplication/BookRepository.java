package com.example.GoodreadsApplication;

import java.util.ArrayList;

interface BookRepository {
    public ArrayList<Book> getBooks();

    public Book getBookById(int bookId);

    public Book AddBook(Book book);

    public Book updateBook(int bookId,Book book);

    public void DeleteBook(int bookId);
}
