package com.heodae.exchangebooks.repository.auth;

import com.heodae.exchangebooks.domain.auth.SignupRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SignupRequestRepository extends JpaRepository<SignupRequest, Long> {
    Optional<SignupRequest> findByEmail(String email);
    boolean existsByEmail(String email);

    // Repository 추가
    List<SignupRequest> findByStatus(SignupRequest.Status status);

    // SignupRequestRepository.java
    Optional<SignupRequest> findByEmailAndStatus(String email, SignupRequest.Status status);


}
