package com.heodae.exchangebooks.controller;

import com.heodae.exchangebooks.domain.auth.SignupRequest;
import com.heodae.exchangebooks.dto.auth.SignupRequestDto;
import com.heodae.exchangebooks.service.auth.SignupService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final SignupService signupService;

    @GetMapping("/login")
    public String loginForm() {
        return "login"; // login.html 반환
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("signup", new SignupRequestDto());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute("signup") SignupRequestDto dto, Model model) {
        try {
            signupService.requestSignup(dto);
            model.addAttribute("message", "가입 요청이 완료되었습니다. 관리자의 승인을 기다려주세요.");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "signup";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, HttpSession session, Model model) {
        SignupRequest user = signupService.findApprovedByEmail(email);

        if (user == null) {
            model.addAttribute("error", "존재하지 않거나 승인되지 않은 이메일입니다.");
            return "login";
        }

        session.setAttribute("loginUser", user.getEmail());
        return "redirect:/"; // 로그인 후 메인으로
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


}
