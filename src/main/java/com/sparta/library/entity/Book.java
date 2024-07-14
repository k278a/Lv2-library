package com.sparta.library.entity;

import com.sparta.library.dto.BookRequestDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity


public class Book {
    @Id // primary key 선언
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //primary  자동적으로 생성
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String language;
    private String date;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;


    public Book() {

    }


    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getLanguage() {
        return language;
    }
    public String getDate() {
        return date;
    }
   public Book (BookRequestDto bookRequestDto){
       this.title = bookRequestDto.getTitle();
       this.author = bookRequestDto.getAuthor();
       this.publisher = bookRequestDto.getPublisher();
       this.language = bookRequestDto.getLanguage();
       this.date = bookRequestDto.getDate();
   }
}
