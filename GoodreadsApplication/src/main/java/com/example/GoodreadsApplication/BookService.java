package com.example.GoodreadsApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.GoodreadsApplication.Book;;
public class BookService implements BookRepository{
  private  HashMap<Integer,Book> hmap= new HashMap<>();
  int uniqueId=3;

public    BookService() {
  Book b1 = new Book(1, "Bagavadgita", "gita.jpg");
  Book b2 = new Book(2, "Ramayanam", "ram.jpg");
  hmap.put(b1.getId() , b1);
  hmap.put(b2.getId(), b2);
  }

@Override
public ArrayList<Book> getBooks() {
            Collection<Book>  booksCollection= hmap.values();
            ArrayList<Book> books =new  ArrayList<>(booksCollection);

    return books;
}

@Override
public Book getBookById(int bookId) {
  Book  book=hmap.get(bookId);
if(book == null) {
    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
}

  return book;
}

public Book AddBook(Book book){
    book.setId(uniqueId);
    hmap.put(uniqueId, book);
    uniqueId +=1;
    return book;

}

public Book updateBook(int bookId,Book book) {
    Book existingBook=hmap.get(bookId);
    if(existingBook == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    if(book.getBookName() != null) {
        existingBook.setBookName(book.getBookName());
    }
    if(book.getImageUrl() != null) {
        existingBook.setImageUrl(book.getImageUrl());
    }
    return book;
}

public void DeleteBook(int bookId) {
    Book existbook = hmap.get(bookId);
    if(existbook == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    if(existbook != null) {
        hmap.remove(bookId);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}

}
