package com.sparta.library.dto;

public class BookRequestDto {
    private String title;
    private String author;
    private String publisher;
    private String language;
    private String date;

    public BookRequestDto() {

    }

    public BookRequestDto(BookRequestDto bookRequestDto) {
        this.title = bookRequestDto.getTitle();
        this.author = bookRequestDto.getAuthor();
        this.publisher = bookRequestDto.getPublisher();
        this.language = bookRequestDto.getLanguage();
        this.date = bookRequestDto.getDate();
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
