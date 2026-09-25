package com.clipquery.clipquery_api.service;

import com.clipquery.clipquery_api.dto.AuthenticationRequest;
import com.clipquery.clipquery_api.dto.AuthenticationResponse;
import com.clipquery.clipquery_api.dto.RegisterRequest;
import com.clipquery.clipquery_api.exception.InvalidUserEmail;
import com.clipquery.clipquery_api.exception.UserAlreadyExistsException;
import com.clipquery.clipquery_api.model.User;
import com.clipquery.clipquery_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        if (!isEmailCorrect(request.getEmail())) {
            throw new InvalidUserEmail("Invalid email: " + request.getEmail());
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("Email already in use: " + request.getEmail());
        }

        var user = User.builder()
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .createdAt(LocalDateTime.now())
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    boolean isEmailCorrect(String email) {
        return email.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}");
    }
}
