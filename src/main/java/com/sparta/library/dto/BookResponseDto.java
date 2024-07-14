package com.sparta.library.dto;
import com.sparta.library.entity.Book;


public class BookResponseDto {
    private long id;
    private String title;
    private String author;
    private String publisher;
    private String language;
    private String date;

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.publisher = book.getPublisher();
        this.language = book.getLanguage();
        this.date = book.getDate();
    }
    public long getId() {
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
}
