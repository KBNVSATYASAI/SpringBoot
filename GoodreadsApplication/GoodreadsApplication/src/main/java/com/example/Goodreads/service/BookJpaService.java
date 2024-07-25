package com.example.Goodreads.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Goodreads.model.Book;
import com.example.Goodreads.repository.BookJpaRepository;
import com.example.Goodreads.repository.BookRepository;

@Service
public class BookJpaService implements BookRepository{
@Autowired
  public BookJpaRepository bookjparepository;
    @Override
    public ArrayList<Book> getBooks() {
         List<Book> listbooks = bookjparepository.findAll();
         ArrayList<Book> books = new ArrayList<>(listbooks);
         return books;
    }

    @Override
    public Book getBookById(int bookId) {
        try{
        Book book=  bookjparepository.findById(bookId).get();
         return  book;
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Book addBook(Book book) {
       Book newBook= bookjparepository.save(book);
        return newBook;
    }

    @Override
    public Book updateBook(int bookId, Book book) {
         try{
                  Book existbook =bookjparepository.findById(bookId).get();
                  if(book.getname() != null) {
                    existbook.setBookname(book.getname());
                  }
                  if(book.getImageUrl() != null) {
                    existbook.setImageUrl(book.getImageUrl());
                  }
                  bookjparepository.save(existbook);
                  return existbook;
         }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
         }
    }

    @Override
    public void DeleteBook(int bookId) {
        try{
              bookjparepository.deleteById(bookId);
        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    
}
