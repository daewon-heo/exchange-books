package com.heodae.exchangebooks.controller;

import com.heodae.exchangebooks.dto.book.BookRequestDto;
import com.heodae.exchangebooks.dto.book.BookResponseDto;
import com.heodae.exchangebooks.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/register-book")
    public String registerForm(Model model) {
        model.addAttribute("book", new BookRequestDto());
        return "register-book";
    }

    @PostMapping("/register-book")
    public String register(@ModelAttribute("book") BookRequestDto dto) {
        bookService.register(dto);
        return "redirect:/all-books";
    }

    @GetMapping("/all-books")
    public String allBooks(Model model) {
        List<BookResponseDto> books = bookService.findAll();
        model.addAttribute("books", books);
        return "all-books";
    }
}
