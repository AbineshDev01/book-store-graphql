package com.example.graphql.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.graphql.model.Author;
import com.example.graphql.model.AuthorInput;
import com.example.graphql.service.AuthorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @MutationMapping
    public Author saveAuthor(@Argument AuthorInput authorInput) {
        return authorService.saveAuthor(authorInput);
    }

    @QueryMapping
    public List<Author> getAllAuthors() {
        return authorService.getAuthors();
    }

    @QueryMapping
    public Author getAuthor(@Argument Integer id) {
        return authorService.getAuthor(id);
    }

    @MutationMapping
    public Author updateAuthor(@Argument Integer id, @Argument AuthorInput authorInput) {
        return authorService.updateAuthor(id, authorInput);
    }

    @MutationMapping
    public boolean deleteAuthor(@Argument Integer id) {
        return authorService.deleteAuthor(id);
    }
}
