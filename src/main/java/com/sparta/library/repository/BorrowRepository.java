package com.sparta.library.repository;

import com.sparta.library.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {
    boolean existsByBookIdAndBorrowedTrue(Long bookId);

    boolean existsByUserIdAndBorrowedTrue(Long userId);

    List<Borrow> findByUserIdOrderByBorrowDateAsc(Long userId);
}
