package com.sparta.library.service;

import com.sparta.library.dto.BookRequestDto;
import com.sparta.library.dto.BookResponseDto;
import com.sparta.library.entity.Book;
import com.sparta.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookResponseDto createBook(BookRequestDto bookRequestDto){
        Book book = new Book(bookRequestDto); // 리팩토링 대상
        Book savedBook = bookRepository.save(book);
        return new BookResponseDto(savedBook);
    }

    public BookResponseDto getChoiceBook(Long id){
        return new BookResponseDto(bookRepository.findById(id).get());
    }

    public List<BookResponseDto> getBooks(){
        List<Book> book  = bookRepository.findAllByOrderByModifiedAtAsc();
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for (Book book1 : book){
            bookResponseDtos.add(new BookResponseDto(book1));
        }
        return bookResponseDtos;
    }







}