package com.heodae.exchangebooks.controller;

import com.heodae.exchangebooks.domain.auth.SignupRequest;
import com.heodae.exchangebooks.service.auth.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final SignupService signupService;

    @GetMapping("/signup-requests")
    public String listSignupRequests(Model model) {
        List<SignupRequest> pendingList = signupService.findPending();
        model.addAttribute("requests", pendingList);
        return "admin/signup-requests";
    }

    @PostMapping("/signup-requests/{id}/approve")
    public String approve(@PathVariable Long id) {
        signupService.approve(id);
        return "redirect:/admin/signup-requests";
    }

    @PostMapping("/signup-requests/{id}/reject")
    public String reject(@PathVariable Long id) {
        signupService.reject(id);
        return "redirect:/admin/signup-requests";
    }
}
