package com.heodae.exchangebooks.service.auth;

import com.heodae.exchangebooks.domain.auth.SignupRequest;
import com.heodae.exchangebooks.dto.auth.SignupRequestDto;
import com.heodae.exchangebooks.repository.auth.SignupRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final SignupRequestRepository repository;

    public void requestSignup(SignupRequestDto dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("이미 가입 요청된 이메일입니다.");
        }

        SignupRequest request = SignupRequest.builder()
                .email(dto.getEmail())
                .build();

        repository.save(request);
    }

    // SignupService.java
    @Transactional
    public void approve(Long id) {
        SignupRequest request = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("가입 요청이 존재하지 않습니다."));
        request.approve();
    }

    public void reject(Long id) {
        SignupRequest request = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("가입 요청이 존재하지 않습니다."));
        request.reject();
    }

    public List<SignupRequest> findPending() {
        return repository.findByStatus(SignupRequest.Status.PENDING);
    }

    public SignupRequest findApprovedByEmail(String email) {
        return repository.findByEmailAndStatus(email, SignupRequest.Status.APPROVED)
                .orElse(null);
    }



}
