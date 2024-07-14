package com.sparta.library.service;

import com.sparta.library.dto.BookRequsetdto;
import com.sparta.library.dto.BookResponsedto;
import com.sparta.library.entity.Book;
import com.sparta.library.Controller.LibraryController;
import com.sparta.library.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookResponsedto createBook(BookRequsetdto bookRequsetdto){
        Book book = new Book(bookRequsetdto); // 리팩토링 대상
        Book savedBook = bookRepository.save(book);
        return new BookResponsedto(savedBook);
    }

    public List<BookResponsedto> getChoicebook(Long id){
        List<Book> book = bookRepository.findAllByOrderByModifiedAtDesc();
    }







}