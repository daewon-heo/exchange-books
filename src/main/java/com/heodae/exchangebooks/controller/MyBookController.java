package com.heodae.exchangebooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyBookController {

    @GetMapping("/my-books")
    public String myBooks() {
        return "my-books";
    }
}
