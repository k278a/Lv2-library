package com.sparta.library.dto;

import com.sparta.library.entity.Borrow;

public class BorrowResponseDto {

    private Long id;
    private boolean success;

    public BorrowResponseDto() {}

    public BorrowResponseDto(Borrow borrow) {
        this.id = borrow.getId();
        this.success = true;
    }

    public Long getId() {
        return id;
    }

    public boolean isSuccess() {
        return success;
    }
}
