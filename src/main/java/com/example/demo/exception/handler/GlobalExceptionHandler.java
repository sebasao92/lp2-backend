package com.example.demo.exception.handler;

import com.example.demo.exception.NotFoundException;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @Value
    private static class ErrorResponse {
        String errorMessage;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException exception) {
        log.error("Validation errors have occurred");
        return ResponseEntity
                .badRequest()
                .body(
                        new ErrorResponse(
                                exception.getBindingResult()
                                        .getFieldErrors().stream()
                                        .map(FieldError::getDefaultMessage)
                                        .collect(Collectors.joining(", "))));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException exception) {
        log.error("Resource was not found: {}", exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(exception.getMessage()));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> handleRemainingExceptions(Throwable exception) {
        log.error("Exception was caught: {}", exception.getMessage());
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse(exception.getMessage()));
    }
}
