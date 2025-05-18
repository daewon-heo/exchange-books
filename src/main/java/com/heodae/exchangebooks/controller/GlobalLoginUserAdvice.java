package com.heodae.exchangebooks.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalLoginUserAdvice {

    @ModelAttribute("loginUser")
    public String loginUser(HttpSession session) {
        return (String) session.getAttribute("loginUser");
    }
}

