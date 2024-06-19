package com.example.graphql.model;

public record BookInput(
    String bookName,
    Integer pages,
    Double price,
    Integer authorId
) {
    
}
