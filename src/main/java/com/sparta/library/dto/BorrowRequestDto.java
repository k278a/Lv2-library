package com.sparta.library.dto;

import java.time.LocalDateTime;

public class BorrowRequestDto {

    private boolean borrowed;
    private LocalDateTime borrowdate;
    private LocalDateTime returndate;
    private Long bookId;
    private Long userId;

    public BorrowRequestDto() {
        this.borrowdate = LocalDateTime.now();
        this.returndate = this.borrowdate.plusDays(7);
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public LocalDateTime getBorrowdate() {
        return borrowdate;
    }

    public LocalDateTime getReturndate() {
        return returndate;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getUserId() {
        return userId;
    }
}
