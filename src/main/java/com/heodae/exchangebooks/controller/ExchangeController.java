package com.heodae.exchangebooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExchangeController {

    @GetMapping("/exchange-requests")
    public String exchangeRequests() {
        return "exchange-requests";
    }

    @GetMapping("/exchange-thread")
    public String exchangeThread() {
        return "exchange-thread";
    }
}
