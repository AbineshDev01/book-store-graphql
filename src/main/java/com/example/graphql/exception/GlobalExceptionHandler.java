package com.example.graphql.exception;

import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import graphql.GraphQLError;

@ControllerAdvice
public class GlobalExceptionHandler {

    @GraphQlExceptionHandler
    public GraphQLError handleException(BookNotFoundException bookNotFoundException) {
        return GraphQLError.newError()
            .message(bookNotFoundException.getMessage())
            .build();
    }

    @GraphQlExceptionHandler
    public GraphQLError handleException(AuthorNotFoundException authorNotFoundException) {
        return GraphQLError.newError()
            .message(authorNotFoundException.getMessage())
            .build();
    }
}
