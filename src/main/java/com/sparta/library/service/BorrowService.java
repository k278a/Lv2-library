package com.sparta.library.service;

import com.sparta.library.dto.BorrowRequestDto;
import com.sparta.library.dto.BorrowResponseDto;
import com.sparta.library.dto.BorrowUpdateResponseDto;
import com.sparta.library.dto.BorrowUserResponseDto;
import com.sparta.library.entity.Book;
import com.sparta.library.entity.Borrow;
import com.sparta.library.entity.User;
import com.sparta.library.repository.BookRepository;
import com.sparta.library.repository.BorrowRepository;
import com.sparta.library.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowService {

    private final BorrowRepository borrowRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public BorrowService(BorrowRepository borrowRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.borrowRepository = borrowRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public BorrowResponseDto borrowing(BorrowRequestDto borrowRequestDto) {
        // 책이 이미 대출되었는지 확인
        if (borrowRepository.existsByBookIdAndBorrowedTrue(borrowRequestDto.getBookId())) { // existsByBookIdAndBorrowedTrue로 변경
            throw new IllegalArgumentException("대출된 도서입니다.");
        }
        // 사용자가 이미 대출 중인지 확인
        if (borrowRepository.existsByUserIdAndBorrowedTrue(borrowRequestDto.getUserId())) { // existsByUserIdAndBorrowedTrue로 변경
            throw new IllegalStateException("사용자가 이미 대출 중인 책이 있습니다.");
        }

        Borrow borrow = new Borrow(borrowRequestDto);
        Borrow savedBorrow = borrowRepository.save(borrow); // 새로운 Borrow 객체를 저장하고 반환
        return new BorrowResponseDto(savedBorrow);
    }


    @Transactional
    public BorrowUpdateResponseDto update(Long id, BorrowRequestDto borrowRequestDto) {
        Borrow borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 정보입니다"));

        // 필요한 부분만 업데이트
        borrow.setBorrowed(borrowRequestDto.isBorrowed());
        if (!borrowRequestDto.isBorrowed()) { // 책이 반납되는 경우
            borrow.setBorrowDate(LocalDateTime.now());
        } else { // 책이 대출되는 경우
            borrow.setBorrowDate(borrowRequestDto.getReturndate());
        }

        Borrow savedBorrow = borrowRepository.save(borrow);
        return new BorrowUpdateResponseDto(savedBorrow);
    }

    public List<BorrowUserResponseDto> getUserBorrow(Long userId){
        List<Borrow> borrows = borrowRepository.findByUserIdOrderByBorrowDateAsc(userId);
        List<BorrowUserResponseDto> borrowList = new ArrayList<>();
        for (Borrow borrow : borrows) {
            User user = findUserById(borrow.getUserId());
            Book book = findBookById(borrow.getBookId());
            borrowList.add(new BorrowUserResponseDto(user,book));
        }

        return borrowList;

    }



    private Borrow findId(Long id){
        return borrowRepository.findById(id).orElse(null);
    }
    private User findUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    private Book findBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

}