package com.example.Goodreads.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Goodreads.model.Book;
//import com.example.Goodreads.repository.BookJpaRepository;
import com.example.Goodreads.service.BookJpaService;
//import com.example.Goodreads.service.Bookh2Service;

@RestController
public class BookController {
   // BookService bs =new BookService();
@Autowired
 public BookJpaService  bs;

@GetMapping("/")
public String welcome(){
    return "hello see the books by add /books to existing path";
}

     @GetMapping("/books")
    public  ArrayList<Book>  getBooks() {
        return   bs.getBooks()   ;
    }


    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId) {
        return bs.getBookById(bookId);
    }

    @PostMapping("/books") 
    public Book AddBook(@RequestBody Book book){
        return bs.addBook(book);
    }

    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable ("bookId") int bookId , @RequestBody Book book) {
        return bs.updateBook(bookId,book);
    }

    @DeleteMapping("/books/{bookId}")
    public  void DeleteBook(@PathVariable("bookId") int bookId){
        bs.DeleteBook(bookId);
     }
}
