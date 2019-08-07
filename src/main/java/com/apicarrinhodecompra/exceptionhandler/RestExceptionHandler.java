package com.apicarrinhodecompra.exceptionhandler;

import com.apicarrinhodecompra.exceptionhandler.error.ErrorResponse;
import com.apicarrinhodecompra.exceptionhandler.error.ObjectError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ObjectError> errors = getErrorsMethodArgumentNotValidException(ex);
        ErrorResponse errorResponse = getErrorMethodArgumentNotValidExceptionResponse(ex, status, errors);
        return new ResponseEntity<>(errorResponse, status);
    }

    private ErrorResponse getErrorMethodArgumentNotValidExceptionResponse(MethodArgumentNotValidException ex, HttpStatus status, List<ObjectError> errors) {
        return new ErrorResponse("Requisição possui campos inválidos", status.value(),
                status.getReasonPhrase(), ex.getBindingResult().getObjectName(), errors);
    }

    private List<ObjectError> getErrorsMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ObjectError(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDuplicateKeyException(DataIntegrityViolationException ex) {
        ErrorResponse errorResponse = getErrorDuplicateKeyExceptionResponse(ex);
        return new ResponseEntity<>(errorResponse,  HttpStatus.BAD_REQUEST);
    }

    private ErrorResponse getErrorDuplicateKeyExceptionResponse(DataIntegrityViolationException ex) {
        return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(), "ConstraintViolationException", Collections.singletonList(new ObjectError( Objects.requireNonNull(ex.getRootCause()).getMessage(), ex.getRootCause().getLocalizedMessage(), null)));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse errorResponse = getHttpMessageNotReadableException(ex);
        return new ResponseEntity<>(errorResponse,  HttpStatus.BAD_REQUEST);
    }

    private ErrorResponse getHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(), "HttpMessageNotReadableException", Collections.singletonList(new ObjectError( Objects.requireNonNull(ex.getRootCause()).getMessage(), ex.getRootCause().getLocalizedMessage(), null)));
    }
}