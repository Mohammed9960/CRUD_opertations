package com.mohammed.librarynew;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class LibraryManagementSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String book;
    private String author;
    private String publishDate;
    private Integer bookVersion;

    public LibraryManagementSystem(String book, String author, String publishDate, Integer bookVersion) {
        this.book = book;
        this.author = author;
        this.publishDate = publishDate;
        this.bookVersion = bookVersion;
    }


}
