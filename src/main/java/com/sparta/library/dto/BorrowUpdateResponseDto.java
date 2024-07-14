package com.sparta.library.dto;

import com.sparta.library.entity.Borrow;

import java.time.LocalDateTime;

public class BorrowUpdateResponseDto {
    private Long id;
    private LocalDateTime returndate;
    private boolean borrowed;

    public BorrowUpdateResponseDto() {

    }
    public BorrowUpdateResponseDto(Borrow borrow) {
        this.borrowed = borrow.isBorrowed();
        this.returndate = LocalDateTime.now();
        this.id = borrow.getId();
    }

    public Long getId() {
        return id;
    }
    public LocalDateTime getReturnDate() {
        return returndate;
    }
    public boolean isBorrowed() {
        return borrowed;
    }


}
