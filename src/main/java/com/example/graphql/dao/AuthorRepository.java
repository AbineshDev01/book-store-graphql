package com.example.graphql.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphql.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
