package com.example.graphql.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.graphql.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("from Book b where b.author.id = :id")
    List<Book> findByAuthor(@Param("id") Integer authorId);

    // another way
    // List<Book> findByAuthorId(Integer authorId);

    // without using param() 
    // @Query("from Book b where b.author.id = :authorId")
    // List<Book> findBookByAuthor(Integer authorId);

    // using ? operator
    // @Query("from Book b where b.author.id = ?1")
    // List<Book> findBooksByAuthor(Integer authorId);
}
