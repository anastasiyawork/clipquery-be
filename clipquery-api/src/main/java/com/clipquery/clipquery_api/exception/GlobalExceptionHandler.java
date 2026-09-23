package com.clipquery.clipquery_api.exception;


import com.clipquery.clipquery_api.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

//    @ExceptionHandler(UserAlreadyExistsException.class)
//    public ResponseEntity<ApiResponse<Void>> handleUserAlreadyExistsException(
//            UserAlreadyExistsException ex, WebRequest request) {
//        log.warn("User with such email already exists: {}", ex.getMessage());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
//                ApiResponse.error(
//                        ex.getMessage()
//                )
//        );
//    }
}
