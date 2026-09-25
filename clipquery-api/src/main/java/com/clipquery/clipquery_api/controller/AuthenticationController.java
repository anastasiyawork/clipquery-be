package com.clipquery.clipquery_api.controller;

import com.clipquery.clipquery_api.dto.AuthenticationRequest;
import com.clipquery.clipquery_api.dto.AuthenticationResponse;
import com.clipquery.clipquery_api.dto.RegisterRequest;
import com.clipquery.clipquery_api.dto.UserInfoDto;
import com.clipquery.clipquery_api.model.User;
import com.clipquery.clipquery_api.repository.UserRepository;
import com.clipquery.clipquery_api.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request) {
        return new ResponseEntity<>(authenticationService.register(request), HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/me")
    @ResponseBody
    public ResponseEntity<UserInfoDto> currentUserInfo(Principal principal) {
        User user = userRepository.findByEmail(principal.getName()).orElseThrow();
        LocalDateTime date = user.getCreatedAt();
        return ResponseEntity.ok(new UserInfoDto(principal.getName(), date));
    }
}
