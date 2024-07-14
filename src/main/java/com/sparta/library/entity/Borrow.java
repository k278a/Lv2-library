package com.sparta.library.entity;

import com.sparta.library.dto.BorrowRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean borrowed;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;
    private Long bookId;
    private Long userId;
    private String userName;
    private String upn;
    private String title;
    private String author;

    public Borrow() {
        this.borrowDate = LocalDateTime.now();
        this.returnDate = this.borrowDate.plusDays(7);
    }

    public Borrow(BorrowRequestDto requestDto) {
        this.borrowed = requestDto.isBorrowed();
        this.borrowDate = requestDto.getBorrowdate();
        this.returnDate = requestDto.getReturndate();
        this.bookId = requestDto.getBookId();
        this.userId = requestDto.getUserId();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getUpn() {
        return upn;
    }
    public String getUserName() {
        return userName;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
    public void setBorrowDate(LocalDateTime returnDate) {
        this.returnDate = LocalDateTime.now();
    }

}
