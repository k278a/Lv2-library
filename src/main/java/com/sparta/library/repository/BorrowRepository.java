package com.sparta.library.repository;

import com.sparta.library.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepositroy extends JpaRepository<Borrow, Long> {
}
