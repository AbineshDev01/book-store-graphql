package com.example.graphql.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.graphql.model.Book;
import com.example.graphql.model.BookInput;
import com.example.graphql.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @MutationMapping
    public Book saveBook(@Argument BookInput bookInput) {
        return bookService.saveBook(bookInput);
    }

    @QueryMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Book getBook(@Argument Integer id) {
        return bookService.getBookById(id);
    }

    @MutationMapping
    public Book updateBook(@Argument Integer id, @Argument BookInput bookInput) {
        return bookService.updateBook(id, bookInput);
    }

    @MutationMapping
    public boolean deleteBook(@Argument Integer id) {
        return bookService.deleteBook(id);
    }
}
