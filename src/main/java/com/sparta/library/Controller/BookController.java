package com.sparta.library.Controller;

import com.sparta.library.dto.bookRequsetDto;
import com.sparta.library.dto.BookResponseDto;
import com.sparta.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class LibraryController {

    private final BookService bookService;

    public LibraryController(BookService bookService){
        this.bookService = bookService;
    }


    @PostMapping("/api/book")
    public BookResponseDto createBook(@RequestBody bookRequsetDto bookRequsetDto){
        return bookService.createBook(bookRequsetDto);
    }

    @GetMapping("/api/book/{id}")
    public BookResponseDto getChoiceBook(@PathVariable Long id){
        return bookService.getChoiceBook(id);
    }





}
