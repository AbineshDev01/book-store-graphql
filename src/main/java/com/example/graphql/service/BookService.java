package com.example.graphql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.graphql.dao.BookRepository;
import com.example.graphql.exception.BookNotFoundException;
import com.example.graphql.model.Book;
import com.example.graphql.model.BookInput;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public Book saveBook(BookInput bookInput) {
        return bookRepository.save(
            new Book(
                bookInput.bookName(), 
                bookInput.price(), 
                bookInput.pages(), 
                authorService.getAuthor(bookInput.authorId())
            )
        );
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getAllBooksByAuthor(Integer authorId) {
        return bookRepository.findByAuthor(authorId);
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book does not exists for the id: " + id));
    }

    public Book updateBook(Integer id, BookInput bookInput) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book does not exists for the id: " + id));
        if(bookInput.bookName() != null) existingBook.setBookName(bookInput.bookName());
        if(bookInput.pages() != null) existingBook.setPages(bookInput.pages());
        if(bookInput.price() != null) existingBook.setPrice(bookInput.price());
        if(bookInput.authorId() != null) existingBook.setAuthor(authorService.getAuthor(bookInput.authorId()));

        return bookRepository.save(existingBook);
    }

    public boolean deleteBook(Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book does not exists for the id: " + id));
        bookRepository.delete(book);
        return true;
    }
}
