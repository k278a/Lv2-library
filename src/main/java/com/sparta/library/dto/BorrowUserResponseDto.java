package com.sparta.library.dto;
import com.sparta.library.entity.Book;
import com.sparta.library.entity.Borrow;
import com.sparta.library.entity.User;

import java.time.LocalDateTime;

public class BorrowUserResponseDto {
    private String userName;
    private String upn;
    private String title;
    private String author;
    private LocalDateTime borrowDate;


    public BorrowUserResponseDto(User user, Book book) {
        this.userName = user.getUsername();
        this.upn = user.getUpn();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.borrowDate = LocalDateTime.now();
    }

    public String getUserName() {
        return userName;
    }
    public String getUpn() {
        return upn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }
}
