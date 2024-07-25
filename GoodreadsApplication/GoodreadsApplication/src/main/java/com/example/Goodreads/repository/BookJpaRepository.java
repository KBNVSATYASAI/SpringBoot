package com.example.Goodreads.repository;

import com.example.Goodreads.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Integer>{

}

    

