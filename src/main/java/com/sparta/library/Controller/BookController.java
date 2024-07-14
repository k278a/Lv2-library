package com.sparta.library.Controller;

import com.sparta.library.dto.BookRequestDto;
import com.sparta.library.dto.BookResponseDto;
import com.sparta.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }


    @PostMapping
    public BookResponseDto createBook(@RequestBody BookRequestDto bookRequestDto){
        return bookService.createBook(bookRequestDto);
    }

    @GetMapping("/{id}")
    public BookResponseDto getChoiceBook(@PathVariable Long id){
        return bookService.getChoiceBook(id);
    }

    @GetMapping
    public List<BookResponseDto> getBooks(){
        return bookService.getBooks();
    }





}
