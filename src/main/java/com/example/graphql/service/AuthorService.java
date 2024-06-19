package com.example.graphql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.graphql.dao.AuthorRepository;
import com.example.graphql.exception.AuthorNotFoundException;
import com.example.graphql.model.Author;
import com.example.graphql.model.AuthorInput;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author saveAuthor(AuthorInput authorInput) {
        return authorRepository.save(
            new Author(authorInput.authorName())
        );
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthor(Integer id) {
        return authorRepository.findById(id)
            .orElseThrow(() -> new AuthorNotFoundException("Author not found with ID: " + id));
    }

    public Author updateAuthor(Integer id, AuthorInput authorInput) {
        Author existingAuthor = authorRepository.findById(id)
            .orElseThrow(() -> new AuthorNotFoundException("Author not found with ID: " + id));
        existingAuthor.setAuthorName(authorInput.authorName());
        return authorRepository.save(existingAuthor);
    }

    public boolean deleteAuthor(Integer id) {
        Author author = authorRepository.findById(id)
            .orElseThrow(() -> new AuthorNotFoundException("Author not found with ID: " + id));
        authorRepository.delete(author);
        return true;
    }
}
