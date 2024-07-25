package com.example.Goodreads.service;
import java.util.ArrayList;
import java.util.List;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Goodreads.model.Book;
import com.example.Goodreads.model.BookRowMapper;
import com.example.Goodreads.repository.BookRepository;
@Service
public class Bookh2Service implements BookRepository{
   
@Autowired
private JdbcTemplate db;

@Override
public ArrayList<Book> getBooks() {

    List<Book> bookList = db.query("SELECT * FROM book", new BookRowMapper());
    ArrayList<Book> books = new ArrayList<>(bookList);
    return books;

}

 @Override
public Book getBookById(int bookId) {
  Book book =  db.queryForObject("select * from book where id = ?",new BookRowMapper() , bookId);
  //Book book = db.queryForObject("select * from book where id = ?", new BookRowMapper(), bookId);

    
    return book;
 }
@Override
public Book addBook(Book book) {
    db.update("insert into book(name, ImageUrl) values (?, ?)", book.getname(), book.getImageUrl());

    Book savedBook = db.queryForObject("select * from book where name = ? and ImageUrl = ?",
                                        new BookRowMapper(), book.getname(), book.getImageUrl());


    return savedBook;
}
@Override
public Book updateBook(int bookId, Book book) {
    if(book.getname() != null) {
    db.update("update book set Name = ? where id = ?" , book.getname(),bookId);
    
    }
    if(book.getImageUrl() != null) {
        db.update("update book set ImageUrl = ? where id = ?", book.getImageUrl() , bookId);
    }
    return getBookById(bookId);
 }
@Override
public void DeleteBook(int bookId) {
  db.update("delete from book where id = ? ", bookId);
}
}