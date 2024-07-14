package com.sparta.library.Controller;

import com.sparta.library.dto.BorrowRequestDto;
import com.sparta.library.dto.BorrowResponseDto;
import com.sparta.library.dto.BorrowUpdateResponseDto;
import com.sparta.library.dto.BorrowUserResponseDto;
import com.sparta.library.service.BorrowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping
    public ResponseEntity<BorrowResponseDto> borrowing(@RequestBody BorrowRequestDto borrowRequestDto) {
        try {
            BorrowResponseDto response = borrowService.borrowing(borrowRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(response); // 201 Created
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error
        }
    }


    @PatchMapping("/{id}")
    public BorrowUpdateResponseDto update(@PathVariable Long id, @RequestBody BorrowRequestDto borrowRequestDto){
        return borrowService.update(id,borrowRequestDto);
    }

    @GetMapping("/{userId}")
    public List<BorrowUserResponseDto> getUserBorrow(@PathVariable Long userId){
        return borrowService.getUserBorrow(userId);
    }


}

