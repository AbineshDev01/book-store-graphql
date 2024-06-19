package com.example.graphql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "books")
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bookName;
    private Double price;
    private Integer pages;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(String bookName, Double price, Integer pages, Author author) {
        this.bookName = bookName;
        this.pages = pages;
        this.price = price;
        this.author = author;
    }
}
