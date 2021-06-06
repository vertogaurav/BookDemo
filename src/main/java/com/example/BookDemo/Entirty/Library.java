package com.example.BookDemo.Entirty;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Storage2")
@Getter
@Setter
public class Library {
    @Column(name = "book_name")
    private String book_name;
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "aisle")
    private int aisle;
    @Column(name = "author")
    private String author;

}
