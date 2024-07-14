package com.sparta.library.dto;

public class BookRequsetDto {
    private String title;
    private String author;
    private String publisher;
    private String language;
    private String date;

    public BookRequsetDto() {

    }

    public BookRequsetDto(BookRequsetDto bookRequsetDto) {
        this.title = bookRequsetDto.getTitle();
        this.author = bookRequsetDto.getAuthor();
        this.publisher = bookRequsetDto.getPublisher();
        this.language = bookRequsetDto.getLanguage();
        this.date = bookRequsetDto.getDate();
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
